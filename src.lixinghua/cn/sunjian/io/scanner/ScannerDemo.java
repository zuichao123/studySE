package cn.sunjian.io.scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import cn.sunjian.utils.CurrentPath;

/**
 * java.io��ϰ��
 * 		
 * 		ʹ��Scanner���������ݣ�
 * 			1.ʵ�ֻ�������������
 *			2.ʵ�����ڸ�ʽ����������
 * 			3.���ļ��еõ�(��ȡ)����
 * 
 * @author sunjian
 */
public class ScannerDemo {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);//���ռ�������
		String str = null;//��ż�������
		
		dataInput(scan,str);//1.ʵ�ֻ�������������
		dateInput(scan,str);//2.ʵ�����ڸ�ʽ����������
		readFile();//3.���ļ��еõ�(��ȡ)����
	}

	/*
	 * ʹ��Scanner���ȡ�ļ�����
	 * ����ļ��У��пո񡢻��е�ʱ��ʹ��StringBuffer�����ա�
	 */
	private static void readFile() {
		File f = new File(CurrentPath.deskTop()+"1.txt");
		Scanner scan = null;
		try {
			scan = new Scanner(f);//��ȡָ���ļ�����
		} catch (FileNotFoundException e) {	
			e.printStackTrace();
		}
		
		StringBuffer sbf = new StringBuffer();//ʹ��StringBuffer���ն�ȡ������
		
		while (scan.hasNext()) {
			sbf.append(scan.nextLine()).append('\n');//��ȡһ�����ݣ�����
		}
		System.out.println("�ļ����ݣ�"+sbf);		
	}

	/*
	 * Scanner����Ȼ���Խ��ո������ͣ����Ƕ��������͵�����ȴ�޷����գ�
	 * �����Ҫ����Date���͵����ݣ���ֻ��ͨ���ַ���ת�ͣ������ڽ��յ�ʱ����Ȼ����ʹ��
	 * Scanner�����ṩ�ķ���������֤��
	 */
	private static void dateInput(Scanner scan,String str) {

		Date date = null;//���ڶ���
		
		System.out.println("���������ڣ�����ʽ��yyyy-MM-dd��");
		
		if (scan.hasNext("^\\d{4}-\\d{2}-\\d{2}$")) {//��������������
			str = scan.next("^\\d{4}-\\d{2}-\\d{2}$");//��������
			try {
				date = new SimpleDateFormat("yyyy-MM-dd").parse(str);//�����յ����ڸ�ʽ���ַ���ת������������
			} catch (ParseException e) {
				e.printStackTrace();
			}
			System.out.println("��������ڣ�"+date);
		}else {
			System.out.println("��������ڸ�ʽ����ȷ��");
		}		
	}

	/*
	 * ��ֱ��ʹ��BufferedReader���ӷ��㡣
	 * �����������֮���пո�����Կո�Ϊ�ָ�����
	 * ���ָ�����Ϊ�س���
	 */
	private static void dataInput(Scanner scan,String str) {
		int i = 0;//�����������
		float f = 0.0f;//��Ÿ���������
		
		System.out.println("�����룺");
				
		if (scan.hasNextInt()) {//��������������
			i = scan.nextInt();//������������
			System.out.println("�������������"+i);
		}else if (scan.hasNextFloat()) {//����������С��
			f = scan.nextFloat();//���ո���������
			System.out.println("�������С����"+f);
		}else{
			scan.useDelimiter("\n");//���÷ָ���Ϊ�س�
			str = scan.next();//��������			
			System.out.println("��������ַ�����"+str);
		}
	}	
}
