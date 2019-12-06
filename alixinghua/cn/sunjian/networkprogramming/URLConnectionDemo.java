package cn.sunjian.networkprogramming;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

/**
 * java网络编程：
 * 
 * 		URLConnection类：
 * 
 * @author jack
 *
 */
public class URLConnectionDemo {

	public static void main(String[] args) throws IOException {

		URL url = new URL("http://www.mldnjava.cn");
		
		URLConnection urlCon = url.openConnection();//建立连接
		
		System.out.println("内容大小："+urlCon.getContentLength());
		System.out.println("内容类型："+urlCon.getContentType());
		
	}

}
