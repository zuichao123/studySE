package cn.sunjian.net.ie_server;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;

public class URLDemo {

	/**
	 * 
	 * @param args
	 * @throws URISyntaxException 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws URISyntaxException, IOException {

		String str_url = "http://127.0.0.1:7777/myweb/1.html";
		
		URL url = new URL(str_url);
		
		System.out.println(""+url.getProtocol());
		System.out.println(""+url.getHost());
		System.out.println(""+url.getPort());
		System.out.println(""+url.getPath());
		System.out.println(""+url.getQuery());

		//获取url对象的URL连接器对象。将连接器封装成了对象::java中内置的可以解析具体协议的对象+socket。
		URLConnection conn = url.openConnection();
		System.out.println(conn);
		
		String value = conn.getHeaderField("content-Type");
		System.out.println(value);
		
		InputStream in = url.openStream();
		byte[] buf = new byte[1024];
		int len = in.read(buf);
		
		String text = new String(buf, 0, len);
		System.out.println(text);
		
		
	}

}
