package cn.sunjian.net.udp.chatdemo;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Rece implements Runnable {
	
	private DatagramSocket ds;
	
	public Rece(DatagramSocket ds) {
		this.ds = ds;
	}

	@Override
	public void run() {
		
		try {
			while(true){
				
				//�������ݰ�
				byte[] buf = new byte[1024];
				DatagramPacket dp = new DatagramPacket(buf, buf.length);
				
				//ʹ�ý��շ��������ݴ洢�����ݰ���
				ds.receive(dp);//����ʽ�ġ����û���յ�����ʱ���ͻ�һֱ�ȡ�
				
				//ͨ�����ݰ�����ķ������������е����ݣ����磺��ַ���˿ڡ��������ݡ�
				String ip = dp.getAddress().getHostAddress();
				int port = dp.getPort();//���Ͷ˵Ķ˿�
				String text = new String(dp.getData(),0,dp.getLength());//ȡ���ݰ��е���Ч����
				
				System.out.print(ip+"::"+text);
				
				if(text.equals("886")){
					System.out.println(ip+"...�˳������ң�");
				}
			}
		}catch(Exception e){
			
		}
	}

}
