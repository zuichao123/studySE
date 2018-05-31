package cn.sunjian.io_encode;

import java.io.IOException;

/**
 * �����
 * 
 * @author sunjian
 *
 */
public class EncodeDemo {

	public static void main(String[] args) throws IOException {

		/*
		 * �ַ���--> �ֽ����飺����
		 * �ַ�����-->�ַ���������
		 * 
		 * ��ã�GBK��-60 -29 -70 -61 
		 * 		UTF-8��-28 -67 -96 -27 -91 -67 
		 * 
		 * �����������ˣ��ⲻ������
		 * 
		 * 
		 */
		
		String str = "���";

		//����
//		byte[] buf = str.getBytes("GBK");
		byte[] buf = str.getBytes("utf-8");
		
		//����
//		String s1 = new String(buf, "GBK");
		String s1 = new String(buf, "utf-8");		
		
		printBytes(buf);
		
		System.out.println(s1);
	}

	public static void printBytes(byte[] buf) {
		
		for(byte b:buf){
			System.out.print(b+" ");
		}
		
		
	}

}
