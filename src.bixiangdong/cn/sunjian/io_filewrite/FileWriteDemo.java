package cn.sunjian.io_filewrite;

import java.io.FileWriter;
import java.io.IOException;


public class FileWriteDemo {

	private static final String LINE_SEPARATOR = System.getProperty("line.separator");

	public static void main(String[] args) throws IOException {

		//����һ���������ļ���д���ַ����ݵ��ַ����������
		/**
		 * ����ļ������ڣ�����Զ�����
		 * ����ļ����ڣ���ᱻ����
		 * 
		 * ������캯���м���true������ʵ�ֶ��ļ�������д��
		 */
		
		FileWriter fw = new FileWriter("demo.txt",true);
	
		/*
		 * ����Writer�����е�write��String��������д������
		 * 
		 * ��ʵ����д�뵽��ʱ�洢��������
		 */
		fw.write("�｡"+LINE_SEPARATOR+"�｡");
		
		/*
		 * ����ˢ�£�������ֱ��д��Ŀ�ĵ���
		 */
		fw.flush();
		
		/*
		 * �ر������ر���Դ.�ڹر�ǰ���ȵ���flush����ˢ�»������е����ݡ�
		 */
		fw.close();
		
	}

}
