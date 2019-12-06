package cn.sunjian.networkprogramming_tcp;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

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
public class HelloServer {

	public static void main(String[] args) {

		ServerSocket server = null;//定义ServerSocket类
		Socket client = null;//表示客户端
		PrintStream out = null;//打印流输出（最方便）
		
		try {
			server = new ServerSocket(9999);//服务器在8888端口上监听
			
			client = server.accept();//得到连接，程序进入到阻塞状态
			
			System.out.println("服务器运行，等待客户端连接。。。");
			
			String str = "Hello World!";
			
			out = new PrintStream(client.getOutputStream());//实例化输入流对象
			
			out.print(str);//向客户端输出信息
			
			client.close();//关闭客户端连接
			
			server.close();//关闭服务端连接
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}