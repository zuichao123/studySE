package cn.sunjian.net_tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientDemo2 {

	/*�ͻ��˷����ݵ������
	 * 
	 * TCP���䣬�ͻ��˽����Ĺ���
	 * 1.����TCP�ͻ���Socket����ʹ�õ���Socket����
	 * 		����ö���һ��������ȷĿ�ĵء�Ҫ���ӵ�������
	 * 2.������ӽ����ɹ���˵�����ݴ���ͨ���ѽ�����
	 * 		��ͨ������Socket�����ǵײ㽨���õģ���Ȼ������˵����������������������
	 * 		��Ҫ���������������󣬿�����Socket����ȡ��
	 * 		����ͨ��getOutputStream()��getInputStream()����ȡ�����ֽ�����
	 * 3.ʹ���������������д������д��������ָ���������ϣ�
	 * 4.�ر���Դ��
	 * 		
	 */
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		//�����ͻ���Socket����
		Socket socket = new Socket("10.2.1.96", 10002);
		
		//��ȡSocket���е������
		OutputStream out = socket.getOutputStream();//���������ùأ���Ϊ��Socket���е�����������Թر�Socket����Ͳ��ù��ˣ�
		
		//ʹ���������ָ��������д��ȥ
		out.write(":tcp ��ʾ�����������ˣ�".getBytes());//��Ϊ���ֽ�������ʹ��getBytes()����
		
		
		//��ȡ����˷��ص����ݣ�ʹ��Socket��ȡ��
		InputStream in = socket.getInputStream();
		//����
		byte[] buf = new byte[1024];
		int len = in.read(buf);
		String text = new String(buf, 0, len);
		
		System.out.println(text);
		
		
		//�ر���Դ(��ʵ���ǽ����ӶϿ�)
		socket.close();
	}

}
