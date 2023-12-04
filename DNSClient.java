import java.io.*;
import java.net.*;
public class DNSClient
{
	public static DatagramSocket ds;
	public static int clientport=859, serverport=860;
	public static void main(String args[]) throws Exception
	{
		System.out.println("\n\n\tDNS Client using UDP\n");
		byte buffer[]=new byte[5178];
		ds=new DatagramSocket(serverport);
		BufferedReader dis=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Server waiting\n");
		InetAddress ia=InetAddress.getLocalHost();
		while(true)
		{
			System.out.println("Client: ");
			String str=dis.readLine();
			if(str.equals("end"))
			{
				break;
			}
			buffer=str.getBytes();
			ds.send(new DatagramPacket(buffer, str.length(), ia, clientport));
			DatagramPacket p=new DatagramPacket(buffer, buffer.length);
			ds.receive(p);
			String psx=new String(p.getData(), 0, p.getLength());
			System.out.println("Server: "+psx);
		}
	}
}