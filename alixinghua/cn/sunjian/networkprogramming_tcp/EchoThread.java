package cn.sunjian.networkprogramming_tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * java网络编程：
 * 
 * 		TCP程序设计：多线程
			Echo程序：
				是一个网络编程通讯交互的一个经典案例，称为回应程序，即：客户端输入那些内容，
				服务器端会在内容前加上“ECHO：”并将信息发送回客户端，下面就完成这个程序
				
		思路：
			服务端的输出就是客户端的输入；
			客户端的输出就是服务器的输入；
 * 
 * @author jack
 *
 */
public class EchoThread implements Runnable {

	private Socket client = null;
	
	public EchoThread(Socket client){
		this.client = client;
	}

	@Override
	public void run() {
		
		BufferedReader bufr = null;//接收输入流
		PrintStream out = null;//打印输出流（最方便）

		try {
			out = new PrintStream(client.getOutputStream());
			bufr = new BufferedReader(new InputStreamReader(client.getInputStream()));//准备接收客户端的输入信息
			
			boolean flag = true;//定义标识位，表示可以一直接收并回应信息
			while(flag){
				String str = bufr.readLine();//接收客户端发送的内容
				if (str==null || "".equals(str)) {
					flag = false;//退出循环
				}else {
					if ("bye".equals(str)) {//如果输入的内容为“bye”
						flag = false;//结束循环
					}else {
						out.println("ECHO："+str);//发送回应信息
					}
				}
			}
			client.close();//关闭客户端连接	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
