import java.io.*;
import java.net.*;
public class ARPServer
{
	public static void main(String args[])
	{
		String IP_Address[]={"192.168.100.1", "192.168.200.1", "192.168.300.1", "192.168.400.1", "192.168.500.1"};
		String MAC_Address[]={"57-H348-B2AQ01JY-6", "93X-H64L-42AM-WHKY-4", "IOV-JK48-2TAB-BEJY-8", "89X-IOZ8-6ZLB-DHJY-3", "XJH-4U18-33IAP-BPYS-7"};
		String send_msg, recv_msg=" ";
		System.out.println("\n\t\t***Implementation of ARP***\n");
		try
		{
			ServerSocket ss=new ServerSocket(9124);
			System.out.println("\nServer started: "+ss);
			Socket s=ss.accept();
			DataInputStream dis=new DataInputStream(s.getInputStream());
			DataInputStream d=new DataInputStream(System.in);
			PrintStream ps=new PrintStream(s.getOutputStream());
			recv_msg=dis.readLine();
			System.out.println("\nRequest received is: "+recv_msg);
			int host_found=0;
			for (int i=0; i<5; i++)
			{
				if (IP_Address[i].equals(recv_msg))
				host_found=i;
			}
			if (host_found!=-1)
			ps.println(MAC_Address[host_found]);
			else
			ps.println(host_found);
			ps.close();
			s.close();
		}catch (Exception se) {System.out.println("Server Socket Problem "+se.getMessage());}
	}
}