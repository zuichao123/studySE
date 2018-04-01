package cn.sunjian.io.transstream.demo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class TransStreamDemo {

	public static void main(String[] args) throws IOException {
		
//		demo_1();//�ֽ�ת�ַ�
//		demo_2();//�ַ�ת�ֽ�
		
		demo_3();//��д--����--����
		
		
	}

	public static void demo_3() throws IOException {
		
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
		
		BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String line = null;
		
		//�ֽ�ת�ַ����
//		while((line=bufr.readLine())!=null){
//			if ("over".equals(line)) {
//				break;
//			}
//			System.out.println(line.toLowerCase());
//		}
		
		//�ַ�ת�ֽ����
		while((line=bufr.readLine())!=null){
			if ("over".equals(line)) {
				break;
			}
			bufw.write(line.toUpperCase());
			bufw.newLine();
			bufw.flush();
		}
	}

	public static void demo_2() throws IOException {
		//�ֽ�������
		InputStream in = System.in;
		//�ֽ�ת�ַ�����
		InputStreamReader isr = new InputStreamReader(in);
		//װ��
		BufferedReader bufr = new BufferedReader(isr);
		
		//�ֽ��� ���
		OutputStream out = System.out;
		//�ַ�ת�ֽڵ������������ַ�ת���ֽڣ�
		OutputStreamWriter ousw = new OutputStreamWriter(out);
		//װ��
		BufferedWriter bufw = new BufferedWriter(ousw);
		
		String line = null;

		while((line=bufr.readLine())!=null){
			if ("over".equals(line)) {
				break;
			}
			bufw.write(line.toUpperCase());
			bufw.newLine();
			bufw.flush();
		}
	}

	/**
	 * @throws IOException
	 */
	public static void demo_1() throws IOException {
		//�ֽ���
		InputStream in = System.in;

		//���ֽ�ת���ַ���������ת������
		InputStreamReader isr = new InputStreamReader(in);
		//�ַ���
		BufferedReader bufr = new BufferedReader(isr);
		
		String line = null;
		
		while((line=bufr.readLine())!=null){
			if("over".equals(line))
				break;
			System.out.println(line.toUpperCase());
		}
	}

}
