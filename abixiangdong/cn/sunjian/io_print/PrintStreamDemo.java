package cn.sunjian.io_print;

import java.io.IOException;
import java.io.PrintStream;

public class PrintStreamDemo {

	public static void main(String[] args) throws IOException {

		/**
		 * PrintStream���ֽڴ�ӡ����
		 * 1,�ṩ�˴�ӡ�������ԶԶ�����������ֵ���д�ӡ�����������ݵı�ʾ��ʽ��
		 * 2��������IOExcetion
		 * 
		 * ���캯����
		 * 1���ַ���·��
		 * 2.File����
		 * 3���ֽ������
		 * 
		 */
		
		PrintStream out = new PrintStream("print.txt");
		
		out.write(97);//ֻд���ݵ����8λ������͵�����ֽڣ�
		
//		out.print(97);//�����ɶ��Ŀ�ĵؾ���ɶ����ʵ���ǽ���ӡ�������ȱ���ַ���Ȼ���ڴ�ӡ��Ŀ�ĵأ�
		
		out.close();
	}

}
