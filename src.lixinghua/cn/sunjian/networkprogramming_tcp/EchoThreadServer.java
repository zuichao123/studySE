package cn.sunjian.networkprogramming_tcp;

import java.io.IOException;
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
public class EchoThreadServer {

	public static void main(String[] args) {

		ServerSocket server = null;//定义ServerSocket类
		Socket client = null;//表示客户端
		boolean f = true;//定义一个标记位
		
		try {
			server = new ServerSocket(9999);//服务器在8888端口上监听
			
			while(f){
				
				System.out.println("服务器运行，等待客户端连接。。。");
				client = server.accept();//得到连接，程序进入到阻塞状态

				new Thread(new EchoThread(client)).start();//每一个客户端表示一个线程
			}
			server.close();//关闭服务端连接	
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * 以上程序为多线程服务端程序
	 */
}
