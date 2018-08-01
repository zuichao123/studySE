package com.sunjian.chatroom_plus;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

import javax.swing.JOptionPane;

/**
 * �ͻ�������
 * 
 * 		���������û������û����Ĵ��룬���Ҳ������û����ظ���
 * 		����֮�⣬�����Ը����û��ļ����������ж��û��Ƿ��뷢��˽����Ϣ��
 * 
 * @author jack
 *
 */
public class Client {

	private static final int SERVER_PORT = 30000;
	private Socket socket;
	private PrintStream ps;
	private BufferedReader brServer;
	private BufferedReader keyIn;
	
	public void init(){
		try {
			//��ʼ��������̵�������
			keyIn = new BufferedReader(new InputStreamReader(System.in));
			//���ӵ�������
			socket = new Socket("127.0.0.1", SERVER_PORT);
			//��ȡ��Socket��Ӧ���������������
			ps = new PrintStream(socket.getOutputStream());
			brServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			String tip = "";
			
			//����ѭ�����ϵĵ����Ի���Ҫ�������û���
			while (true) {
				String userName = JOptionPane.showInputDialog(tip + "�����û���");
				//���û�������û���ǰ������Э���ַ�������
				ps.println(CrazyitProtocol.USER_ROUND + userName + CrazyitProtocol.USER_ROUND);
				//��ȡ�������˵���Ӧ
				String result = brServer.readLine();
				//����û����ظ�����ʼ�´�ѭ��
				if (result.equals(CrazyitProtocol.NAME_REP)) {
					tip = "�û����ظ���������";
					continue;
				}
				//����������˷��ص�¼�ɹ��������ѭ��
				if (result.equals(CrazyitProtocol.LOGIN_SUCCESS)) {
					break;
				}
			}
		} catch (Exception e) {
			//�����쳣���ر�������Դ�����Ƴ��ĳ���
			
			
			
			//.............
			
			
			
		}
	}
	
}
