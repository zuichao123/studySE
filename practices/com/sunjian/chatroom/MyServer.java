package com.sunjian.chatroom;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
/**
 * �����
 * ServerSocket����������
 * 
 * @author jack
 *
 */
public class MyServer {
	//���屣������Socket��ArrayList
	public static ArrayList<Socket> socketList = new ArrayList<>();
	
	@SuppressWarnings("resource")
	public static void main(String[] args)throws IOException{
		
		ServerSocket ss = new ServerSocket(30000);
		while(true){
			//���д������������һֱ�ȴ����˵�����
			Socket s = ss.accept();
			socketList.add(s);
			//ÿ���ͻ������Ӻ�����һ��ServerThread�߳�Ϊ�ÿͻ��˷���
			new Thread(new ServerThread(s)).start();
		}
	}
}
