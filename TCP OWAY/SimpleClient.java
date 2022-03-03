import java.net.*;
import java.io.*;

public class SimpleClient
{
public static void main(String args[]) throws IOException
{

Socket s1 = new Socket("localhost",1254);

InputStream s1In = s1.getInputStream();
DataInputStream dis = new DataInputStream(s1In);
String st= new String(dis.readUTF());

System.out.println(st);

dis.close();
s1In.close();
s1.close();
}
}
