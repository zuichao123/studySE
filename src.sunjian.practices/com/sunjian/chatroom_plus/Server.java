package com.sunjian.chatroom_plus;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.sunjian.chatroom.ServerThread;

/**
 * �������˵�����һ��ֻ�ǽ���ServerSocket���������Կͻ���Socket����������
 * 
 * @author jack
 *
 */
public class Server {

	private static final int SERVER_PORT = 30000;
	//ʹ��CrazyitMap����������ÿ���ͻ����ֺͶ�Ӧ�����֮��Ķ�Ӧ��ϵ
	public static CrazyitMap<String, PrintStream> clients = new CrazyitMap<>();
	
	public void init(){
		try {
			//����������ServerSocket
			ServerSocket ss = new ServerSocket(SERVER_PORT);
			
				//������ѭ�������ϵؽ������Կͻ��˵�����
				while(true){
					Socket socket = ss.accept();
					new ServerThread(socket);
				}
			
		} catch (IOException e) {
			//����׳��쳣
			System.out.println("����������ʧ�ܣ��Ƿ�˿�"+SERVER_PORT+"�ѱ�ռ�ã�");
		}
	}
	
	public static void main(String[] args) {
		Server server = new Server();
		server.init();
	}
}
