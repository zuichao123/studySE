package cn.sunjian.networkprogramming_tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
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
public class EchoServer {

	public static void main(String[] args) {

		ServerSocket server = null;//����ServerSocket��
		Socket client = null;//��ʾ�ͻ���
		PrintStream out = null;//��ӡ���������㣩
		BufferedReader bufr = null;//����������
		boolean f = true;//����һ�����λ
		
		try {
			server = new ServerSocket(9999);//��������8888�˿��ϼ���
			
			while(f){
				
				System.out.println("���������У��ȴ��ͻ������ӡ�����");
				client = server.accept();//�õ����ӣ�������뵽����״̬

				out = new PrintStream(client.getOutputStream());
				bufr = new BufferedReader(new InputStreamReader(client.getInputStream()));//׼�����տͻ��˵�������Ϣ
				
				boolean flag = true;//�����ʶλ����ʾ����һֱ���ղ���Ӧ��Ϣ
				while(flag){
					String str = bufr.readLine();//���տͻ��˷��͵�����
					if (str==null || "".equals(str)) {
						flag = false;//�˳�ѭ��
					}else {
						if ("bye".equals(str)) {//������������Ϊ��bye��
							flag = false;//����ѭ��
						}else {
							out.println("ECHO��"+str);//���ͻ�Ӧ��Ϣ
						}
					}
				}
				client.close();//�رտͻ�������	
			}
			server.close();//�رշ��������
			
			
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * ���ϳ�����ͬһʱ�����ֻ����һ���ͻ��ˣ������Ҫ����ͻ��˵Ļ�������ʹ�ö��߳�
	 */
}
