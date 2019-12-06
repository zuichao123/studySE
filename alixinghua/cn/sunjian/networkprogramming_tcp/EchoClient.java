package cn.sunjian.networkprogramming_tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * java网络编程：
 * 
 * 		TCP程序设计：
 * 			Echo程序：
				是一个网络编程通讯交互的一个经典案例，称为回应程序，即：客户端输入那些内容，
				服务器端会在内容前加上“ECHO：”并将信息发送回客户端，下面就完成这个程序
 * 
 * @author jack
 *
 */
public class EchoClient {

	public static void main(String[] args) {

		Socket client = null;//表示客户端
		BufferedReader bufr = null;//一次性接收完成
		PrintStream out = null;//发送数据
		BufferedReader input = null;//接收键盘数据
		
		try {
			client = new Socket("localhost", 9999);
			input = new BufferedReader(new InputStreamReader(System.in));
			bufr = new BufferedReader(new InputStreamReader(client.getInputStream()));
			out = new PrintStream(client.getOutputStream());
			
			boolean flag = true;//定义标识位
			while(flag){
				System.out.print("输入信息：");
				String str = input.readLine();//接收键盘的输入信息
				out.println(str);//发送信息
				
				if ("bye".equals(str)) {
					flag = false;//结束循环
				}else{
					String echo = bufr.readLine();//接收返回信息
					System.out.println(echo);//输出返回信息
				}
			}
			
			bufr.close();
			client.close();	
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
