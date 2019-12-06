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
	 * 读取键盘数据
	 */
	@Override
	public void run() {
		
		try{
			BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
			String line = null;
			
			while((line=bufr.readLine())!=null){
				
				//使用DatagramSocket将数据封装到该对象包中
				byte[] buf = line.getBytes();
				
				DatagramPacket dp = new DatagramPacket(buf/*发送的内容*/, buf.length/*内容的长度*/, InetAddress.getByName("192.168.1.255")/*发送的地址*/, 10001/*端口号*/);
				
				//通过UDP的Socket服务将数据包发送出去 ，使用send方法。
				ds.send(dp);
				
				//如果键盘输入886，退出程序
				if ("886".equals(line))
					break;		
			}
			//关闭服务
			ds.close();
		}catch(Exception e){
			
		}
	}

}
