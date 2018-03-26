package cn.sunjian.net.udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * UDP����:���Ͷ�
 * 
 * @author jack
 *
 */

public class UDPSendDemo2 {

	public static void main(String[] args) throws IOException {
		
		System.out.println("���Ͷ�������������");

		/*
		 * ����udp����ķ��Ͷ�
		 * 
		 * ˼·��
		 * 	1.����UDP��Socket����
		 * 	2.��Ҫ���͵����ݷ�װ�����ݰ��У�
		 * 	3.ͨ��UDP��Socket�������ݰ����ͳ�ȥ��
		 * 	4.�ر�Socket����
		 */
		
		//1.UDPSocket����ʹ��DatagramSocket���󣬣���ָ�����͵Ķ˿ڡ�
		DatagramSocket ds = new DatagramSocket(9999);
		
		//2.��ȡ����¼�뵽���ݰ���
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		
		while((line=bufr.readLine())!=null){
			
			//ʹ��DatagramSocket�����ݷ�װ���ö������
			byte[] buf = line.getBytes();
			
			DatagramPacket dp = new DatagramPacket(buf/*���͵�����*/, buf.length/*���ݵĳ���*/, InetAddress.getByName("10.2.1.96")/*���͵ĵ�ַ*/, 10000/*�˿ں�*/);
			
			//3.ͨ��UDP��Socket�������ݰ����ͳ�ȥ ��ʹ��send������
			ds.send(dp);
			
			if ("886".equals(line))
				break;		
		}
		
		//4.�ر���Դ
		ds.close();
	}

}
