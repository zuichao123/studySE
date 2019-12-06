package cn.sunjian.networkprogramming;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * java�����̣�
 * 
 * 		InetAddress�ࣺ
 * 			
 * 
 * @author jack
 *
 */
public class InetAddressDemo {

	public static void main(String[] args) {

		InetAddress locAdd = null;//������ַ����
		InetAddress remAdd = null;//Զ�̵�ַ����
		
		try {
			locAdd = InetAddress.getLocalHost();//�õ�����
			remAdd = InetAddress.getByName("http://www.mldnjava.cn");//�õ�Զ�̵�ַ
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
		System.out.println("������ip��ַ��"+locAdd.getHostAddress());
		System.out.println("Զ�̵�ip��ַ��"+remAdd.getHostAddress());
		
		try {
			System.out.println("�����Ƿ�ɴ"+locAdd.isReachable(5000));//�����Ƿ�ɴ��ʱ5�뷵��
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
