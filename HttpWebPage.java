import java.net.*;
import java.io.*;
public class HttpWebPage
{
	public static void main(String args[]) throws Exception
	{
		URL url=new URL(args[0]);
		InputStream is=url.openStream();
		DataInputStream dis=new DataInputStream(is);
		String s=" ";
		while ((s=dis.readLine())!=null)
		System.out.println(s);
		dis.close();
		is.close();
	}
}