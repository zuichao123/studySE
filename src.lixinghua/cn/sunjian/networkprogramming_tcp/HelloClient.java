package cn.sunjian.networkprogramming_tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * java�����̣�
 * 
 * 		TCP������ƣ�
 * 			ͨ��ServerSocket��Socket�����һ���������ĳ��򿪷����˷�������ͻ��������Hello World�������ַ�����Ϣ��
 * 
 * 		C/s�ܹ���������/�ͻ��ˣ�
 * 
 * @author jack
 *
 */
public class HelloClient {

	public static void main(String[] args) {

		Socket client = null;//��ʾ�ͻ���
		BufferedReader bufr = null;//һ���Խ������
		
		try {
			client = new Socket("localhost", 9999);
			
			bufr = new BufferedReader(new InputStreamReader(client.getInputStream()));
			
			String str = bufr.readLine();
			
			System.out.println("�������������ݣ�"+str);
			
			bufr.close();
			
			client.close();
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
