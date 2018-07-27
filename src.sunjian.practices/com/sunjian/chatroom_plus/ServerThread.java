package com.sunjian.chatroom_plus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * ���������߳��ࣺ
 * 		�ֱ����ġ�˽������������Ϣ
 * 		�����û����Ƿ��ظ�������
 * 	
 * @author jack
 *
 */
public class ServerThread extends Thread {
	private Socket socket;
	BufferedReader br = null;
	PrintStream ps = null;
	
	//����һ�������������ڽ���һ��Socket������ServerThread�߳�
	public ServerThread(Socket socket){
		this.socket = socket;
	}
	
	public void run(){
		try {
			//��ȡ��Socket��Ӧ��������
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			//��ȡ��Socket��Ӧ�������
			ps = new PrintStream(socket.getOutputStream());
			String line = null;
			while((line = br.readLine()) != null){
				//�������������CrazyitProtocol.USER_ROUND��ʼ������������������ȷ���������û���¼���û���
				if(line.startsWith(CrazyitProtocol.USER_ROUND) && line.endsWith(CrazyitProtocol.USER_ROUND)){
					//�õ���ʵ��Ϣ
					String userName = getRealMsg(line);
					//����û����ظ�
					if(Server.clients.containsKey(userName)){
						System.out.println("�ظ�");
						ps.println(CrazyitProtocol.NAME_REP);
					}else {
						System.out.print("�ɹ�");
						ps.println(CrazyitProtocol.LOGIN_SUCCESS);
						Server.clients.put(userName, ps);
					}
				}
				//�������������CrazyitProtocol.PRIVATE_ROUND��ʼ�����������
				//�����ȷ��ʱ˽����Ϣ��˽����Ϣֻ���ض������������
				else if(line.startsWith(CrazyitProtocol.PRIVATE_ROUND) && line.endsWith(CrazyitProtocol.PRIVATE_ROUND)){
						//�õ���ʵ��Ϣ
						String userAndMsg = getRealMsg(line);
						//��SPLIT_SIGN�ָ��ַ�����ǰ����˽���û��������������Ϣ
						String user = userAndMsg.split(CrazyitProtocol.SPLIT_SIGN)[0];
						String msg = userAndMsg.split(CrazyitProtocol.SPLIT_SIGN)[1];
						//��ȡ˽���û���Ӧ���������������˽����Ϣ
						Server.clients.get(user).println(Server.clients.getKeyByValue(ps) + "���Ķ���˵��"+msg);
					}//����Ҫ��ÿ��Socket����
					else {
						//�õ���ʵ��Ϣ
						String msg = getRealMsg(line);
						//����clients�е�ÿ�������
						for(PrintStream clientPs : Server.clients.valueSet()){
							clientPs.println(Server.clients.getKeyByValue(ps)+"˵��"+msg);
						}
					}
				}
			//........
			
			
			
		} catch (IOException e) {
			// TODO: handle exception
		}
	}

	private String getRealMsg(String line) {
		// TODO Auto-generated method stub
		return null;
	}
}
