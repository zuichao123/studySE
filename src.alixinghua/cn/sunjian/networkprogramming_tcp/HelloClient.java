package cn.sunjian.networkprogramming_tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * java网络编程：
 * 
 * 		TCP程序设计：
 * 			通过ServerSocket和Socket类完成一个服务器的程序开发，此服务器向客户端输出“Hello World！”的字符串信息。
 * 
 * 		C/s架构，服务器/客户端；
 * 
 * @author jack
 *
 */
public class HelloClient {

	public static void main(String[] args) {

		Socket client = null;//表示客户端
		BufferedReader bufr = null;//一次性接收完成
		
		try {
			client = new Socket("localhost", 9999);
			
			bufr = new BufferedReader(new InputStreamReader(client.getInputStream()));
			
			String str = bufr.readLine();
			
			System.out.println("服务器接收内容："+str);
			
			bufr.close();
			
			client.close();
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
