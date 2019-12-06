package cn.sunjian.net_uploadpic;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class UploadPicClient {

	/**
	 * 
	 * @param args
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws UnknownHostException, IOException {
		

		//1�������ͻ���socket
		Socket s = new Socket("10.2.1.96",10006);
		
		//2.��ȡ�ͻ���Ҫ�ϴ���ͼƬ�ļ�
		FileInputStream fis = new FileInputStream("E:\\0.bmp");
		
		//3,��ȡSocket���������������ͼƬ���ݷ��͸������
		OutputStream out = s.getOutputStream();
		
		byte[] buf = new byte[1024];
		
		int len = 0;
		
		while((len=fis.read(buf))!=-1){
			out.write(buf,0,len);
		}
		
		//���߷����˵����ߵ����ݷ�����ϣ��÷����ֹͣ��ȡ
		s.shutdownOutput();
		
		//��ȡ����˷��ص�����
		InputStream in = s.getInputStream();
		
		@SuppressWarnings("unused")
		byte[] bufIn = new byte[1024];
		
		int lenIn = in.read(buf);
		String text = new String(buf,0,lenIn);
		System.out.println(text);
		
		fis.close();
		s.close();
		
	}

}
