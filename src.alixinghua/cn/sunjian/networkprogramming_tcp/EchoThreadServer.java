package cn.sunjian.networkprogramming_tcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * java�����̣�
 * 
 * 		TCP������ƣ�
			Echo����
				��һ��������ͨѶ������һ�����䰸������Ϊ��Ӧ���򣬼����ͻ���������Щ���ݣ�
				�������˻�������ǰ���ϡ�ECHO����������Ϣ���ͻؿͻ��ˣ����������������
				
		˼·��
			����˵�������ǿͻ��˵����룻
			�ͻ��˵�������Ƿ����������룻
 * 
 * @author jack
 *
 */
public class EchoThreadServer {

	public static void main(String[] args) {

		ServerSocket server = null;//����ServerSocket��
		Socket client = null;//��ʾ�ͻ���
		boolean f = true;//����һ�����λ
		
		try {
			server = new ServerSocket(9999);//��������8888�˿��ϼ���
			
			while(f){
				
				System.out.println("���������У��ȴ��ͻ������ӡ�����");
				client = server.accept();//�õ����ӣ�������뵽����״̬

				new Thread(new EchoThread(client)).start();//ÿһ���ͻ��˱�ʾһ���߳�
			}
			server.close();//�رշ��������	
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * ���ϳ���Ϊ���̷߳���˳���
	 */
}
