package cn.sunjian.networkprogramming_tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * java网络编程：
 * 
 * 		TCP程序设计：
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
public class EchoServer {

	public static void main(String[] args) {

		ServerSocket server = null;//定义ServerSocket类
		Socket client = null;//表示客户端
		PrintStream out = null;//打印流输出（最方便）
		BufferedReader bufr = null;//接收输入流
		boolean f = true;//定义一个标记位
		
		try {
			server = new ServerSocket(9999);//服务器在8888端口上监听
			
			while(f){
				
				System.out.println("服务器运行，等待客户端连接。。。");
				client = server.accept();//得到连接，程序进入到阻塞状态

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
			}
			server.close();//关闭服务端连接
			
			
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * 以上程序在同一时间段上只能有一个客户端，如果想要多个客户端的话，必须使用多线程
	 */
}
