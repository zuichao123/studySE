package cn.sunjian.net.udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * UDP传输:发送端
 * 
 * @author jack
 *
 */

public class UDPSendDemo2 {

	public static void main(String[] args) throws IOException {
		
		System.out.println("发送端启动。。。。");

		/*
		 * 创建udp传输的发送端
		 * 
		 * 思路：
		 * 	1.建立UDP的Socket服务；
		 * 	2.将要发送的数据封装到数据包中；
		 * 	3.通过UDP的Socket服务将数据包发送出去；
		 * 	4.关闭Socket服务。
		 */
		
		//1.UDPSocket服务。使用DatagramSocket对象，，并指定发送的端口。
		DatagramSocket ds = new DatagramSocket(9999);
		
		//2.读取键盘录入到数据包中
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		
		while((line=bufr.readLine())!=null){
			
			//使用DatagramSocket将数据封装到该对象包中
			byte[] buf = line.getBytes();
			
			DatagramPacket dp = new DatagramPacket(buf/*发送的内容*/, buf.length/*内容的长度*/, InetAddress.getByName("10.2.1.96")/*发送的地址*/, 10000/*端口号*/);
			
			//3.通过UDP的Socket服务将数据包发送出去 ，使用send方法。
			ds.send(dp);
			
			if ("886".equals(line))
				break;		
		}
		
		//4.关闭资源
		ds.close();
	}

}
