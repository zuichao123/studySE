package cn.sunjian.io.bufferedreader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BufferedReader�ࣺ������ϰ
 * 
 * 		��ȡ����¼�����Ϣ��
 * 		һ�ζ�ȡһ�У�
 * 		����ӡ��������̨��
 * 
 * @author jack
 *
 */
public class BufferedReaderDemo {

	public static void main(String[] args) {

		BufferedReader buf = null;//��������
		
		buf = new BufferedReader(new InputStreamReader(System.in));
		
		String str = null;//�������������
		
		System.out.println("�����룺");
		
		try {
			str = buf.readLine();//��ȡһ������
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("�������Ϣ��"+str);//�����Ϣ
		
	}

	/*
	 * ��ʱ����������ܳ������ݣ�ÿ��һ�س�Ϊ������
	 */
}
