import java.io.*;
import java.net.*;
public class EchoServer
{
	public static void main(String args[]) throws Exception
	{
		ServerSocket ss=new ServerSocket(12543);
		Socket s=ss.accept();
		DataInputStream dis=new DataInputStream(s.getInputStream());
		DataInputStream d=new DataInputStream(System.in);
		PrintStream ps=new PrintStream(s.getOutputStream());
		String s1=dis.readLine();
		System.out.println("Message from Client: "+s1);
		System.out.println("Echo from Server: "+s1);
		ps.println(s1);
		ss.close();
		s.close();
	}
}