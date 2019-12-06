package cn.sunjian.net_ip;

/**
 * 本地ip地址和主机名的获取方式
 */

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPDemo {

	public static void main(String[] args) throws UnknownHostException {

		//获取本地主机ip地址对象
		InetAddress ip = InetAddress.getLocalHost();
		
		//获取其他主机的ip地址对象
		ip = InetAddress.getByName("www.baidu.com");
		
		System.out.println(ip.getHostName());
		System.out.println(ip.getHostAddress());
	}

}
