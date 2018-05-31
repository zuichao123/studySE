package cn.sunjian.networkprogramming_udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * java�����̣�UDP�������
 * 
 * 		�������ˣ�
 * 
 * @author jack
 *
 */
public class UDPServer {

	public static void main(String[] args) {

		DatagramSocket ds = null;//����������ݱ��Ķ��󣨷������ݣ�
		DatagramPacket dp = null;//����DatagramPacket���󣨰�װ���ݣ�
		
		try {
			ds = new DatagramSocket(3000);//�������3000�˿��ϵȴ�������������Ϣ
		} catch (SocketException e) {
			e.printStackTrace();
		}
		
		String str = "hello world!";//���͵���Ϣ
		
		try {
			dp = new DatagramPacket(str.getBytes(),str.length(),
					InetAddress.getByName("localhost"),9000);
		} catch (UnknownHostException e1) {
			e1.printStackTrace();
		}
		
		try {
			ds.send(dp);//��������
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
