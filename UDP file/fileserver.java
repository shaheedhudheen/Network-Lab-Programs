import java.io.*;
import java.net.*;
class fileserver
{
public static DatagramSocket serversocket;
public static DatagramPacket dp;
public static BufferedReader br;
public static InetAddress ia;
public static byte buf[]=new byte[1024];
public static int cport=2221,sport=5552;
public static void main(String[] args) throws IOException
{
serversocket=new DatagramSocket(sport);
dp=new DatagramPacket(buf,buf.length);
BufferedReader br=new BufferedReader (new InputStreamReader(System.in));
ia=InetAddress.getLocalHost();
System.out.println("Server is running.....");
while(true)
{
serversocket.receive(dp);
String str2=new String(dp.getData(),0,dp.getLength());
if(str2.equals("exit"))
{
System.out.println("Terminated...");
break;
}
File file=new File(str2);
BufferedReader f=new BufferedReader(new FileReader(file));
String str4;
while((str4=f.readLine())!=null)
System.out.println(str4);
//System.out.println("Client said : "+str2);
String str3=new String(br.readLine());
buf=str3.getBytes();
serversocket.send(new DatagramPacket(buf,str3.length(),ia,cport));
}
}
}