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
				
				//创建数据包
				byte[] buf = new byte[1024];
				DatagramPacket dp = new DatagramPacket(buf, buf.length);
				
				//使用接收方法将数据存储到数据包中
				ds.receive(dp);//阻塞式的。如果没有收到数据时，就会一直等。
				
				//通过数据包对象的方法，解析其中的数据，比如：地址、端口、数据内容。
				String ip = dp.getAddress().getHostAddress();
				int port = dp.getPort();//发送端的端口
				String text = new String(dp.getData(),0,dp.getLength());//取数据包中的有效数据
				
				System.out.print(ip+"::"+text);
				
				if(text.equals("886")){
					System.out.println(ip+"...退出聊天室！");
				}
			}
		}catch(Exception e){
			
		}
	}

}
