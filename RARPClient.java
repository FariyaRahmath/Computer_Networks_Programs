import java.io.*;
import java.net.*;
public class RARPClient
{
	public static void main(String args[])
	{
		String send_msg, recv_msg=" ";
		try
		{
			InetAddress ip=InetAddress.getLocalHost();
			Socket s=new Socket(ip, 9126);
			PrintStream ps=new PrintStream(s.getOutputStream());
			DataInputStream dis=new DataInputStream(s.getInputStream());
			DataInputStream d=new DataInputStream(System.in);
			System.out.println("\n\t\t***Implementation of RARP***\n");
			System.out.println("\nEnter the MAC Address: ");
			send_msg=d.readLine();
			ps.println(send_msg);
			recv_msg=dis.readLine();
			if (!recv_msg.equals("-1"))
			{
				System.out.println("\nIP Address of given MAC Address: ");
				System.out.println(recv_msg);
			}
			else
			{
				System.out.println("Host Not Found\n");
			}
			ps.close();
			s.close();
		}catch (Exception se) {System.out.println("Exception: "+se.getMessage());}
	}
}