package cn.sunjian.io.printstream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/**
 * ��ӡ����ϰ��
 * 
 * 		�ֽڴ�ӡ��:PrintStream
 * 
 * @author jack
 *
 */
public class PrintStreamDemo {

	public static void main(String[] args) throws IOException {

		PrintStream ps = null;//�����ֽڴ�ӡ������
		
		//ʵ��������
		ps = new PrintStream(new FileOutputStream(new File("c:"+File.separator+"text7.txt")));
	
		ps.print("today is sunday!");
		ps.println("tomorrow is monday!");
		ps.print("1+1="+2);
	
		String name = "sunjian";
		int age = 30;
		char sex = 'M';
		float score = 99.999f;
		
		ps.printf("������%s,���䣺%d,�Ա�%c,�ɼ���%f",name,age,sex,score);
		
		ps.close();//�رմ�ӡ��
	}

}
