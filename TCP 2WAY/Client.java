import java.net.*;
import java.io.*;


class Client
{
public static void main(String args[]) throws IOException
{

Socket s = new Socket("localhost",1254);


DataOutputStream dos = new DataOutputStream(s.getOutputStream());


BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
BufferedReader kb = new BufferedReader(new InputStreamReader(System.in));

String str, str1;

while(!(str = kb.readLine()).equals("exit")){
dos.writeBytes(str+"\n");
str1 = br.readLine();
System.out.println(str1);
}

dos.close();
br.close();
kb.close();
s.close();
}
}