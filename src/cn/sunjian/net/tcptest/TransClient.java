package cn.sunjian.net.tcptest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class TransClient {

	public static void main(String[] args) throws UnknownHostException, IOException {

		/*
		 * ˼·��
		 * �ͻ��ˣ�
		 * 1.��Ҫ����Socket�˵㡣
		 * 2.�ͻ��˵�����Դ������
		 * 3.�ͻ��˵�Ŀ�ģ�Socket
		 * 4.���շ���˵����ݣ�Դ��Socket
		 * 5.��������ʾ����ӡ������Ŀ�ģ�����̨
		 * 6������Щ���в��������ݣ������ı����ݡ�
		 * 
		 * ת���ͻ��ˣ�
		 * 1.����Socket�ͻ��˶���
		 * 2.��ȡ����¼�롣
		 * 3.��¼�����Ϣ���͸�Socket�������
		 */
		
		//����Socket�ͻ��˶���
		Socket s = new Socket("10.2.1.96", 10004);
		
		//��ȡ����¼��
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
		
		//socket�����
		PrintWriter/*�ַ���*/ out = new PrintWriter(s.getOutputStream(),true);
		
		//Socket����������ȡ����˷��صĴ�д����
		BufferedReader burIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
		
		String line = null;
		
		while((line=bufr.readLine())!=null){
			if ("over".equals(line))
				break;
			out.println(line);
			
			//��ȡ����˷��ص�һ�д�д��
			String upperStr = burIn.readLine();
			System.out.println(upperStr);		
		}
		
		//�ر���
		s.close();
	}

}
