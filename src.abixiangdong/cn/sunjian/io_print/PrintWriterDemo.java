package cn.sunjian.io_print;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class PrintWriterDemo {

	public static void main(String[] args) throws IOException {

		/**
		 * PrintWriter:�ַ���ӡ��(��֤���ݵ�ԭ��ʱ��)
		 * 
		 * ���캯��������
		 * 1���ַ���·��
		 * 2��File����
		 * 3���ֽ������
		 * 4���ַ������
		 * 
		 * ���⣺ʹ��newLine()����������BufferedWriter
		 */
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));//�����ַ���ȡ������ȡ����
		
//		PrintWriter out = new PrintWriter(System.out,true);//�����ַ���ӡ������ӡ����̨
		PrintWriter out = new PrintWriter(new FileWriter("out.txt"),true);//���ַ���ӡ������һ���ַ������FileWriter������out.txt�ļ�
		
		String line = null;
		
		while((line = bufr.readLine())!=null){//�����ȡ�������ݲ�Ϊ��
			if("over".equals(line))  //�����ȡ��������Ϊover
				break;              //����ѭ��
			out.println(line);//���д�ӡ��ȡ��������
//			out.flush();    //ˢ��(����ڴ�ӡ�ַ����д���true�����Բ���flush)
		}
		
		out.close();//�ر��ַ���ӡ��
		bufr.close();//�ر��ַ���ȡ��
	}

}
