import java.io.*;
import java.net.*;

class fileserver {

	public static void main(String args[]) throws Exception{
		ServerSocket ss = new ServerSocket(6666);
		Socket s = ss.accept();
		System.out.println("Connection established");
		PrintStream ps = new PrintStream(s.getOutputStream());
	
		BufferedReader br = new BufferedReader(	new InputStreamReader(s.getInputStream()));
		BufferedReader kb = new BufferedReader(new InputStreamReader(System.in));
		//File file=new File("D:/cn lab/detail.txt");
		//BufferedReader f=new BufferedReader(new FileReader(file));
		
		while (true) {
			String str, str1;
			
			while ((str = br.readLine()) != null) {
                   File file=new File(str);
		BufferedReader f=new BufferedReader(new FileReader(file));              
				//System.out.println(str);
				String str2;
				while((str2=f.readLine())!=null)
				System.out.println(str2);
				str1 = kb.readLine();
				ps.println(str2);
			}
			ps.close();
			br.close();
			kb.close();
			ss.close();
			s.close();
			
			System.exit(0);

		}
	}
}