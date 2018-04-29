package cn.sunjian.io.filereader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * ʹ���ַ���������Reader�����ȡ������
 * 	
 * 		ʹ���ַ�����ȡ����
 * 
 * 			���ַ��������ʽ��ȡ����
 * 
 * @author jack
 *
 */
public class FileReaderDemo {

	public static void main(String[] args) throws IOException {

		noCycleReader();
		cycleReader();
	}

	/*
	 * ʹ��ѭ���ķ�ʽ��ȡ���ж��ļ��Ƿ�����׵ķ�ʽ��
	 */
	private static void cycleReader() throws IOException {

		File  file2 = new File("c:"+File.separator+"text2.txt");//ָ���ļ�
		
		Reader fr2 = null;//�����ַ����루��ȡ��������
		
		fr2 = new FileReader(file2);//ʹ������ʵ��������
		
		char[] c2 = new char[1024];//����char���飬�������ö�ȡ��������
		

		/*
		 * ʹ��read()������ѭ����ȡ���ݣ�һ�ζ�ȡһ���ַ��ķ�ʽ��
		 * ��ÿ�ζ�ȡ�������ݣ��洢���ַ�������
		 */
		int temp = 0;//���ڴ�����ݣ����ж����ݵ�ĩβ�Ƿ�Ϊ-1�������-1������û�������ˣ�������
		
		int len = 0;//���ڼ�¼�ַ��ĸ�������Ҫ��Ϊ�˸�������ָ����λ�ã�˳��������
		
		while((temp = fr2.read()) != -1){//�ж϶�ȡ���������Ƿ���
			
			c2[len] = (char)temp;//����ȡ�����ݴ洢���ַ�������
			len++;//������¼�ַ��ĸ�����λ�ã�
			
		}
		
		System.out.println("contents:\r\n"+new String(c2,0,len));
		
		fr2.close();//�ر�������
	}

	/*
	 * ���ַ�����ķ�ʽ��ȡ
	 */
	private static void noCycleReader() throws FileNotFoundException, IOException {
		File  file = new File("c:"+File.separator+"text2.txt");//ָ���ļ�
		
		Reader fr = null;//�����ַ����루��ȡ��������
		
		fr = new FileReader(file);//ʹ������ʵ��������
		
		char[] c = new char[1024];//����char���飬�������ö�ȡ��������
		
		int len = fr.read(c);//��ȡ���ݵ��ַ�����c�У�����������ĳ���
		
		System.out.println("contents:\r\n"+new String(c,0,len));
		
		fr.close();//�ر�������
	}

}
