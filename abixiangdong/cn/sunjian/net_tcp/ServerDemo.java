package cn.sunjian.net_tcp;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {

	/*服务端接收客户端发送过来的数据，并打印在控制台上
	 * 
	 * 建立TCP服务端的思路：
	 * 1.创建服务端Socket服务。通过ServerSocket对象。
	 * 2.服务端必须对外提供一个端口，否则客户端无法连接。
	 * 3。获取连接过来的客户端对象。
	 * 4.通过客户端对象获取Socket流读取客户端发来的数据。，并打印在控制台上。
	 * 5。关闭资源，关闭客户端、关闭服务端。
	 * 
	 */
	
	public static void main(String[] args) throws IOException {
	
		//创建服务端对象
		ServerSocket ss = new ServerSocket(10002);
		
		//获取连接过来的客户端对象
		Socket s = ss.accept();//获取客户端对象方法
		
		//获取客户端ip地址
		String ip = s.getInetAddress().getHostAddress();
		
		//通过Socket对象获取输入流，要读取客户端发来的数据
		InputStream in = s.getInputStream();
		
		//自定义缓冲区
		byte[] buf = new byte[1024];
		
		int len = in.read(buf);
		String text = new String(buf, 0, len);
		System.out.println(ip+text);
		
		//关闭客户端
		s.close();
		//关闭服务端（服务器一般不关闭）
		ss.close();
	}

}
