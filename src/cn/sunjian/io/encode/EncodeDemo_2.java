package cn.sunjian.io.encode;

import java.io.IOException;

public class EncodeDemo_2 {

	public static void main(String[] args) throws IOException {

		/*
		 * �ַ���--> �ֽ����飺����
		 * �ַ�����-->�ַ���������
		 * 
		 * ��ã�GBK��-60 -29 -70 -61 
		 * 		UTF-8��-28 -67 -96 -27 -91 -67 
		 * 
		 * �����������ˣ��ⲻ������
		 * �������ˣ��п����оȡ�
		 * 
		 * 
		 */
		
		String str = "���";
		//����
		byte[] buf = str.getBytes("gbk");
		//����
		String s1 = new String(buf, "iso8859-1");
		
		System.out.println("s1="+s1);
		//����
		byte[] buf2 = s1.getBytes("iso8859-1");
		//����
		String s2 = new String(buf2, "GBK");
		
		System.out.println("s2="+s2);
		
		
	}

}
