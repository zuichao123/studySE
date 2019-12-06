package cn.sunjian.networkprogramming_tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * java�����̣�
 * 
 * 		TCP������ƣ�
 * 			Echo����
				��һ��������ͨѶ������һ�����䰸������Ϊ��Ӧ���򣬼����ͻ���������Щ���ݣ�
				�������˻�������ǰ���ϡ�ECHO����������Ϣ���ͻؿͻ��ˣ����������������
 * 
 * @author jack
 *
 */
public class EchoClient {

	public static void main(String[] args) {

		Socket client = null;//��ʾ�ͻ���
		BufferedReader bufr = null;//һ���Խ������
		PrintStream out = null;//��������
		BufferedReader input = null;//���ռ�������
		
		try {
			client = new Socket("localhost", 9999);
			input = new BufferedReader(new InputStreamReader(System.in));
			bufr = new BufferedReader(new InputStreamReader(client.getInputStream()));
			out = new PrintStream(client.getOutputStream());
			
			boolean flag = true;//�����ʶλ
			while(flag){
				System.out.print("������Ϣ��");
				String str = input.readLine();//���ռ��̵�������Ϣ
				out.println(str);//������Ϣ
				
				if ("bye".equals(str)) {
					flag = false;//����ѭ��
				}else{
					String echo = bufr.readLine();//���շ�����Ϣ
					System.out.println(echo);//���������Ϣ
				}
			}
			
			bufr.close();
			client.close();	
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
