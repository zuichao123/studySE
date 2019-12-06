package cn.sunjian.networkprogramming_udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * java网络编程：UDP程序设计
 * 
 * 		客户端；必须先打开
 * 
 * @author jack
 *
 */
public class UDPClient {

	public static void main(String[] args) {

		DatagramSocket ds = null;//定义接收数据报的对象（发送数据）
		DatagramPacket dp = null;//声明DatagramPacket对象（包装数据）
		byte[] buf = new byte[1024];//开辟空间，以接收数据
		
		try {
			ds = new DatagramSocket(9000);//客户端在9000端口上等待服务器发送信息
		} catch (SocketException e) {
			e.printStackTrace();
		}
		
		dp = new DatagramPacket(buf, 1024);//所有的信息使用buf保存
		
		try {
			ds.receive(dp);//接收数据
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String str = new String(dp.getData(),0,dp.getLength()) + " from " + 
				dp.getAddress().getHostAddress() + ":" + dp.getPort();
		
		System.out.println(str);//输出内容
		
	}

}
