package cn.sunjian.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class TransStreamDemo {

	public static void main(String[] args) throws IOException {

//		writeText_3();
//		readText_1();
		readText_2();
	}
	
	public static void readText_2() throws IOException{
		// TODO Auto-generated method stub
		InputStreamReader isr= new InputStreamReader(new FileInputStream("gbk_1.txt"),"UTF-8");
	
		char[] buf = new char[10];
		int len= isr.read(buf);
		String str = new String(buf, 0, len);
		System.out.println(str);
			
		isr.close();
	}

	public static void readText_1() throws IOException {
		// TODO Auto-generated method stub
		FileReader fr = new FileReader("u8_1.txt");
		
		char[] buf = new char[10];
		int len= fr.read(buf);
		String str = new String(buf, 0, len);
		System.out.println(str);
			
		fr.close();
	}

	public static void writeText_3() throws IOException, FileNotFoundException {

		OutputStreamWriter osw  = new OutputStreamWriter(new FileOutputStream("u8_1.txt"),"UTF-8");
		
		osw.write("��ð�");
		osw.close();
		
	}

	public static void writeText_2() throws IOException {
		
		OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("gbk_2.txt"));
	
		osw.write("���");
		
		osw.close();
		
	}
	/**
	 * ���������Ĺ����ǵ�ͬ�ġ�
	 *FileWriter����ʵ����ת����ָ���˱���Ĭ���������֣��������ת������������󣬿��Է�������ı��ļ�
	 *	��˵�������ļ����ֽ���+����Ĭ�ϵı����
	 *	���ǰ���Ĭ������������ļ��ı���ࡣ
	 *	
	 * @throws IOException
	 */

	public static void writeText_1() throws IOException {
		FileWriter fw = new FileWriter("gbk_1.txt");
		fw.write("���");
		
		fw.close();
		
	}

}
