package com.sunjian.chatroom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * ClientThread�����ȡSocket��Ӧ�������е����ݣ��ӷ������˷��͹��������ݣ���������Щ���ݴ�ӡ�����
 * 
 * 
 * @author jack
 *
 */
public class ClientThread implements Runnable {
	
	//���̸߳������Socket
	private Socket s;
	//���߳��������Socket��Ӧ����������
	BufferedReader br = null;
	
	public ClientThread(Socket s) throws IOException {
		this.s = s;
		this.br = new BufferedReader(new InputStreamReader(s.getInputStream()));
	}

	@Override
	public void run() {
		try {
			String content = null;
			//���϶�ȡSocket�������е����ݣ�������Щ���ݴ�ӡ���
			while((content = br.readLine()) != null){
				System.out.println(content);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
