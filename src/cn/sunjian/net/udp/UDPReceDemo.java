package cn.sunjian.net.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * UDP���䣺���ն�
 * 
 * @author jack
 *
 */

public class UDPReceDemo {

	public static void main(String[] args) throws IOException {
		
		System.out.println("���ն���������������");

		/*
		 * ����UDP���ն˵�˼·��
		 * 
		 * ˼·��
		 * 	1.����UDP Socket������Ϊ��Ҫ�������ݣ�����Ҫ��ȷһ���˿ںš�
		 * 	2.�������ݰ������ڴ洢���յ������ݡ����������ݰ�����ķ���������Щ���ݡ�
		 * 	3.ʹ��Socket�����receive���������յ����ݴ洢�����ݰ��С�
		 * 	4.ͨ�����ݰ��ķ����������ݰ��е����ݡ�
		 * 	5.�ر���Դ��
		 */
		
		//1.����UDP Socket���񣬲���һ���뷢�Ͷ�һ�µĶ˿�
		DatagramSocket ds = new DatagramSocket(10000);
		
		//2.�������ݰ�
		byte[] buf = new byte[1024];
		DatagramPacket dp = new DatagramPacket(buf, buf.length);
		
		//3.ʹ�ý��շ��������ݴ洢�����ݰ���
		ds.receive(dp);//����ʽ�ġ����û���յ�����ʱ���ͻ�һֱ�ȡ�
		
		//4.ͨ�����ݰ�����ķ������������е����ݣ����磺��ַ���˿ڡ��������ݡ�
		String ip = dp.getAddress().getHostAddress();
		int port = dp.getPort();//���Ͷ˵Ķ˿�
		String text = new String(dp.getData(),0,dp.getLength());//ȡ���ݰ��е���Ч����
		
		System.out.print(ip+":");
		System.out.print(port+":");
		System.out.println(text);
		
		//5.�ر���Դ
		ds.close();
	}

}
