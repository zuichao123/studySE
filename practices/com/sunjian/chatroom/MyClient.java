package com.sunjian.chatroom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import com.sunjian.chatroom.*;

/**
 * ÿ���ͻ���Ӧ�ð��������̣߳�һ�������ȡ�û��ļ������룬�����û����������д��Socket��Ӧ��������У�
 * һ�������ȡSocket��Ӧ�������е����ݣ��ӷ������˷��͹��������ݣ���������Щ���ݴ�ӡ�����
 * ���и����ȡ�û�����������߳���MyClient����Ҳ�����г�������̸߳���
 * @author jack
 *
 */
public class MyClient {

	public static void main(String[] args) throws Exception, IOException {

		Socket s = new Socket("127.0.0.1", 30000);
		//�ͻ�������ClientThread�̲߳��ϵض�ȡ���Է�����������
		new Thread(new ClientThread(s)).start();
		//��ȡ��Socket��Ӧ�������
		PrintStream ps = new PrintStream(s.getOutputStream());
		String line = null;
		//���ϵض�ȡ��������
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while((line = br.readLine()) != null){
			//���û��ļ�����������д��Socket��Ӧ�������
			ps.println(line);
		}
	}
}
