package cn.sunjian.networkprogramming;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * java网络编程：
 * 
 * 		InetAddress类：
 * 			
 * 
 * @author jack
 *
 */
public class InetAddressDemo {

	public static void main(String[] args) {

		InetAddress locAdd = null;//本机地址对象
		InetAddress remAdd = null;//远程地址对象
		
		try {
			locAdd = InetAddress.getLocalHost();//得到本机
			remAdd = InetAddress.getByName("http://www.mldnjava.cn");//得到远程地址
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
		System.out.println("本机的ip地址："+locAdd.getHostAddress());
		System.out.println("远程的ip地址："+remAdd.getHostAddress());
		
		try {
			System.out.println("本机是否可达："+locAdd.isReachable(5000));//本机是否可达，延时5秒返回
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
