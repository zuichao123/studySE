package cn.sunjian.net_tcp;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {

	/*����˽��տͻ��˷��͹��������ݣ�����ӡ�ڿ���̨��
	 * 
	 * ����TCP����˵�˼·��
	 * 1.���������Socket����ͨ��ServerSocket����
	 * 2.����˱�������ṩһ���˿ڣ�����ͻ����޷����ӡ�
	 * 3����ȡ���ӹ����Ŀͻ��˶���
	 * 4.ͨ���ͻ��˶����ȡSocket����ȡ�ͻ��˷��������ݡ�������ӡ�ڿ���̨�ϡ�
	 * 5���ر���Դ���رտͻ��ˡ��رշ���ˡ�
	 * 
	 */
	
	public static void main(String[] args) throws IOException {
	
		//��������˶���
		ServerSocket ss = new ServerSocket(10002);
		
		//��ȡ���ӹ����Ŀͻ��˶���
		Socket s = ss.accept();//��ȡ�ͻ��˶��󷽷�
		
		//��ȡ�ͻ���ip��ַ
		String ip = s.getInetAddress().getHostAddress();
		
		//ͨ��Socket�����ȡ��������Ҫ��ȡ�ͻ��˷���������
		InputStream in = s.getInputStream();
		
		//�Զ��建����
		byte[] buf = new byte[1024];
		
		int len = in.read(buf);
		String text = new String(buf, 0, len);
		System.out.println(ip+text);
		
		//�رտͻ���
		s.close();
		//�رշ���ˣ�������һ�㲻�رգ�
		ss.close();
	}

}
