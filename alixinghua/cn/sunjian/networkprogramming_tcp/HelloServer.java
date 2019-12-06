package cn.sunjian.networkprogramming_tcp;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

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
public class HelloServer {

	public static void main(String[] args) {

		ServerSocket server = null;//����ServerSocket��
		Socket client = null;//��ʾ�ͻ���
		PrintStream out = null;//��ӡ���������㣩
		
		try {
			server = new ServerSocket(9999);//��������8888�˿��ϼ���
			
			client = server.accept();//�õ����ӣ�������뵽����״̬
			
			System.out.println("���������У��ȴ��ͻ������ӡ�����");
			
			String str = "Hello World!";
			
			out = new PrintStream(client.getOutputStream());//ʵ��������������
			
			out.print(str);//��ͻ��������Ϣ
			
			client.close();//�رտͻ�������
			
			server.close();//�رշ��������
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}