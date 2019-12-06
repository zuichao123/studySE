package cn.sunjian.net_udp_chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Send implements Runnable {
	
	private DatagramSocket ds;
	
	public Send(DatagramSocket ds) {
		this.ds = ds;
	}

	/**
	 * ��ȡ��������
	 */
	@Override
	public void run() {
		
		try{
			BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
			String line = null;
			
			while((line=bufr.readLine())!=null){
				
				//ʹ��DatagramSocket�����ݷ�װ���ö������
				byte[] buf = line.getBytes();
				
				DatagramPacket dp = new DatagramPacket(buf/*���͵�����*/, buf.length/*���ݵĳ���*/, InetAddress.getByName("192.168.1.255")/*���͵ĵ�ַ*/, 10001/*�˿ں�*/);
				
				//ͨ��UDP��Socket�������ݰ����ͳ�ȥ ��ʹ��send������
				ds.send(dp);
				
				//�����������886���˳�����
				if ("886".equals(line))
					break;		
			}
			//�رշ���
			ds.close();
		}catch(Exception e){
			
		}
	}

}
