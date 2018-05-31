package cn.sunjian.net_ie_server;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class MyBrowser {

	/**
	 * 
	 * @param args
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws UnknownHostException, IOException {

		Socket s = new Socket("127.0.0.1",7777);
		
		//模拟浏览器，给Tomcat服务端发送符号http协议的请求消息。
		PrintWriter out = new PrintWriter(s.getOutputStream(),true);
		
		out.println("GET / HTTP/1.1");
		out.println("Accept:*/*");
		out.println("Host:127.0.0.1:7777");
		out.println("Connection:close");
		
		out.println();
		out.println();
		
		InputStream in = s.getInputStream();
		
		byte[] buf = new byte[1024];
		int len = in.read(buf);
		
		String str = new String(buf, 0, len);
		System.out.println(str);
		
		s.close();	
		
	}

}
