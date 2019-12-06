package cn.sunjian.networkprogramming_tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * java�����̣�
 * 
 * 		TCP������ƣ����߳�
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
public class EchoThread implements Runnable {

	private Socket client = null;
	
	public EchoThread(Socket client){
		this.client = client;
	}

	@Override
	public void run() {
		
		BufferedReader bufr = null;//����������
		PrintStream out = null;//��ӡ���������㣩

		try {
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
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
