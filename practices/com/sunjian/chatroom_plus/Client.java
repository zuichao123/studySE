package com.sunjian.chatroom_plus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

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
		} catch (UnknownHostException e) {
			//�����쳣���ر�������Դ�����˳��ĳ���
			System.out.println("�Ҳ���Զ�̷���������ȷ���������Ѿ�������");
			closeRs();
			System.exit(1);	
		}catch (IOException e) {
			System.out.println("�����쳣�������µ�¼��");
			closeRs();
			System.exit(1);
		}
		//�Ը�Socket��Ӧ������������ClientThread�߳�
		new ClientThread(brServer).start();
	}

	//����һ����ȡ����������������緢�͵ķ���
	private void readAndSend(){
		try {
			//���ϵض�ȡ��������
			String line = null;
			while((line = keyIn.readLine()) != null){
				//������͵���Ϣ����ð�ţ�����/��ͷ������Ϊ�뷢��˽����Ϣ
				if(line.indexOf(":") > 0 && line.startsWith("/")){
					line = line.substring(1);
					ps.println(CrazyitProtocol.PRIVATE_ROUND + line.split(":")[0] + CrazyitProtocol.SPLIT_SIGN + line.split(":")[1] + CrazyitProtocol.PRIVATE_ROUND);
				}else {
					ps.println(CrazyitProtocol.MSG_ROUND + line + CrazyitProtocol.MSG_ROUND);
				}
			}
		} catch (IOException e) {//�����쳣���ر�������Դ�����˳��ó���
			System.out.println("����ͨ���쳣�������µ�¼��");
			closeRs();
			System.exit(1);
		}
	}
	
	//�ر�Socket����������������ķ���
	private void closeRs() {
		try{
			if(keyIn != null){
				ps.close();
			}
			if (brServer != null) {
				ps.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (socket != null) {
				keyIn.close();
			}
		}catch (IOException e) {
			Client client = new Client();
			client.init();
			client.readAndSend();
		}
	}
	
}
