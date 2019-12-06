package cn.sunjian.networkprogramming_udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * java�����̣�UDP�������
 * 
 * 		�ͻ��ˣ������ȴ�
 * 
 * @author jack
 *
 */
public class UDPClient {

	public static void main(String[] args) {

		DatagramSocket ds = null;//����������ݱ��Ķ��󣨷������ݣ�
		DatagramPacket dp = null;//����DatagramPacket���󣨰�װ���ݣ�
		byte[] buf = new byte[1024];//���ٿռ䣬�Խ�������
		
		try {
			ds = new DatagramSocket(9000);//�ͻ�����9000�˿��ϵȴ�������������Ϣ
		} catch (SocketException e) {
			e.printStackTrace();
		}
		
		dp = new DatagramPacket(buf, 1024);//���е���Ϣʹ��buf����
		
		try {
			ds.receive(dp);//��������
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String str = new String(dp.getData(),0,dp.getLength()) + " from " + 
				dp.getAddress().getHostAddress() + ":" + dp.getPort();
		
		System.out.println(str);//�������
		
	}

}
