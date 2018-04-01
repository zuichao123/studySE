package cn.sunjian.net.udp.chatdemo;

import java.io.IOException;
import java.net.DatagramSocket;

/**
 * 
 * @author sunjian
 *
 */
public class ChatDemo {

	public static void main(String[] args) throws IOException {

		//发送
		DatagramSocket send = new DatagramSocket();
		//接收（要指定端口）
		DatagramSocket rece = new DatagramSocket(10001);
		
		//线程任务
		new Thread(new Send(send)).start();
		new Thread(new Rece(rece)).start();
	}

}
