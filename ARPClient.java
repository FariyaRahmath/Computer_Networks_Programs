import java.io.*;
import java.net.*;
public class ARPClient
{
	public static void main(String args[])
	{
		String send_msg, recv_msg=" ";
		try
		{
			InetAddress ip=InetAddress.getLocalHost();
			Socket s=new Socket(ip, 9124);
			PrintStream ps=new PrintStream(s.getOutputStream());
			DataInputStream dis=new DataInputStream(s.getInputStream());
			DataInputStream d=new DataInputStream(System.in);
			System.out.println("\n\t\t***Implementation of ARP***\n");
			System.out.println("\nEnter the IP Address: ");
			send_msg=d.readLine();
			ps.println(send_msg);
			recv_msg=dis.readLine();
			if (!recv_msg.equals("-1"))
			{
				System.out.println("\nMAC Address of given IP Address: ");
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