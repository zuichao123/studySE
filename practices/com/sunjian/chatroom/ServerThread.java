package com.sunjian.chatroom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * �����
 * ���������߳���
 * ������ÿ��Socketͨ�ŵ��߳���
 * @author jack
 *
 */
public class ServerThread implements Runnable {
	//���嵱ǰ�߳��������Socket
	Socket s = null;
	//���߳��������Socket��Ӧ��������
	BufferedReader br = null;
	
	public ServerThread(Socket s)throws IOException{
		this.s = s;
		//��ʼ����Socket��Ӧ��������
		this.br = new BufferedReader(new InputStreamReader(s.getInputStream()));
	}
	
	
	@Override
	public void run() {
		try {
			String content = null;
			//����ѭ�����ϵش�Socket�ж�ȡ�ͻ��˷��͹���������
			while((content = readFromClient()) != null){
				//����socketList�е�ÿ��Socket
				//��������������ÿ��Socket����һ��
				for(Socket s : MyServer.socketList){
					PrintStream ps = new PrintStream(s.getOutputStream());
					ps.println(content);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//�����ȡ�ͻ������ݵķ���
	private String readFromClient() {
		try{
			return br.readLine();
		}catch (IOException e) {
			//�����׽���쳣���������Socket��Ӧ�Ŀͻ����Ѿ��ر�
			//ɾ����Socket
			MyServer.socketList.remove(s);
		}
		return null;
	}

}
