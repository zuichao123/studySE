package cn.sunjian.net.tcptest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class TransClient {

	public static void main(String[] args) throws UnknownHostException, IOException {

		/*
		 * 思路：
		 * 客户端：
		 * 1.需要先有Socket端点。
		 * 2.客户端的数据源：键盘
		 * 3.客户端的目的：Socket
		 * 4.接收服务端的数据：源：Socket
		 * 5.将数据显示并打印出来，目的：控制台
		 * 6。在这些流中操作的数据，都是文本数据。
		 * 
		 * 转换客户端：
		 * 1.创建Socket客户端对象。
		 * 2.获取键盘录入。
		 * 3.将录入的信息发送给Socket输出流。
		 */
		
		//创建Socket客户端对象
		Socket s = new Socket("10.2.1.96", 10004);
		
		//获取键盘录入
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
		
		//socket输出流
		PrintWriter/*字符流*/ out = new PrintWriter(s.getOutputStream(),true);
		
		//Socket输入流，读取服务端返回的大写数据
		BufferedReader burIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
		
		String line = null;
		
		while((line=bufr.readLine())!=null){
			if ("over".equals(line))
				break;
			out.println(line);
			
			//读取服务端发回的一行大写数
			String upperStr = burIn.readLine();
			System.out.println(upperStr);		
		}
		
		//关闭流
		s.close();
	}

}
