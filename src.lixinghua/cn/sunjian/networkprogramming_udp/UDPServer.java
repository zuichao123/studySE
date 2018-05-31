package cn.sunjian.networkprogramming_udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * java网络编程：UDP程序设计
 * 
 * 		服务器端；
 * 
 * @author jack
 *
 */
public class UDPServer {

	public static void main(String[] args) {

		DatagramSocket ds = null;//定义接收数据报的对象（发送数据）
		DatagramPacket dp = null;//声明DatagramPacket对象（包装数据）
		
		try {
			ds = new DatagramSocket(3000);//服务端在3000端口上等待服务器发送信息
		} catch (SocketException e) {
			e.printStackTrace();
		}
		
		String str = "hello world!";//发送的信息
		
		try {
			dp = new DatagramPacket(str.getBytes(),str.length(),
					InetAddress.getByName("localhost"),9000);
		} catch (UnknownHostException e1) {
			e1.printStackTrace();
		}
		
		try {
			ds.send(dp);//发送数据
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
