package cn.sunjian.net_tcptest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TransServer {

	public static void main(String[] args) throws IOException {
		
		/*
		 * ת������ˣ�
		 * ������
		 * 1.ServerSocket����
		 * 2.��ȡSocket����
		 * 3.Դ��Socket����ȡ�ͻ��˷���������Ҫת�������ݡ�
		 * 4.Ŀ�ģ���ʾ�ڿ���̨�ϡ�
		 * 5.������ת�ɴ�д�����ͻ��ˡ�
		 */
		
		//����ServerSocket�������
		ServerSocket ss = new ServerSocket(10004);
		
		//��ȡSocket����
		Socket s = ss.accept();
		
		//��ȡip
		String ip = s.getInetAddress().getHostAddress();
		System.out.println(ip+"......connected");
		
		//��ȡSocket��ȡ������װ�Ρ�
		BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
		
		//��ȡSocket���������װ��
		PrintWriter out = new PrintWriter(s.getOutputStream(),true);//true�Զ�ˢ��
		
		String line = null;
		while((line=bufIn.readLine())!=null){
			System.out.println(line);
			out.println(line.toUpperCase());//println���б��
		}
		
		s.close();
		ss.close();
	}

}
