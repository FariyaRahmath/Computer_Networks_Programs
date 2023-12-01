import java.io.*;
import java.net.*;
public class ChatClient
{
	public static void main(String args[]) throws Exception
	{
		Socket s=new Socket("LocalHost", 12501);
		DataInputStream dis=new DataInputStream(s.getInputStream());
		DataInputStream d=new DataInputStream(System.in);
		PrintStream ps=new PrintStream(s.getOutputStream());
		String s1=" ", s2=" ";
		while(!(s1.equals("stop") && s2.equals("stop")))
		{
			System.out.println("\nYou: ");
			s1=d.readLine();
			ps.println(s1);
			s2=dis.readLine();
			System.out.println("\nServer: "+s2);
		}
		s.close();
	}
}