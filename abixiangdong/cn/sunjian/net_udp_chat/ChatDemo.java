package cn.sunjian.net_udp_chat;

import java.io.IOException;
import java.net.DatagramSocket;

/**
 * 
 * @author sunjian
 *
 */
public class ChatDemo {

	public static void main(String[] args) throws IOException {

		//����
		DatagramSocket send = new DatagramSocket();
		//���գ�Ҫָ���˿ڣ�
		DatagramSocket rece = new DatagramSocket(10001);
		
		//�߳�����
		new Thread(new Send(send)).start();
		new Thread(new Rece(rece)).start();
	}

}
