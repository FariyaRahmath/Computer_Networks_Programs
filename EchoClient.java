import java.io.*;
import java.net.*;
public class EchoClient
{
	public static void main(String args[]) throws Exception
	{
		Socket s=new Socket("localhost", 12543);
		DataInputStream dis=new DataInputStream(s.getInputStream());
		DataInputStream d=new DataInputStream(System.in);
		PrintStream ps=new PrintStream(s.getOutputStream());
		System.out.println("Enter the message: ");
		String s1=d.readLine();
		ps.println(s1);
		System.out.println("Message received from Server: ");
		String s2=dis.readLine();
		System.out.println(s2);
		s.close();
	}
}