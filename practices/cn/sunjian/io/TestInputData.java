package cn.sunjian.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

/**
 * java.IO������ʵ��һ��ϰ
 * 
 * 	������
 * 		1.����Ҫ��Ӽ��������������֣�֮������������ֵļӷ����������Ρ������ͣ�
 * 		2.�ж�������Ƿ�������
 * 	˼·��
 * 		��Ϊ�Ӽ��̽��չ���������ȫ���ǲ����ַ�������ʽ��ŵģ�����
 * 		��ʱֱ�ӽ��ַ���ͨ����װ��Integer���ַ�����Ϊ�����������͡�
 * 			
 * 		
 * @author sunjian
 *
 */
public class TestInputData {

	public static void main(String[] args) throws IOException {

		newIntAddMethod();
		
		oldIntAddMethod();
		
		floatAddMethod();
		
		dateMethod();
			
	}

	private static void dateMethod() {
		
		InputData input = new InputData();
		
		Date date = input.getDate("���������ڣ���ʽΪ��yyyy-MM-dd����", "����������ڸ�ʽ����ȷ�����������룡");
		
		System.out.println(date);
	}

	private static void floatAddMethod() {
		
		float i = 0;
		float j = 0;
		
		InputData input = new InputData();
		
		i = input.getFloat("�������һ��С����", "����Ĳ���С�������������룡");
		j = input.getFloat("������ڶ���С����", "����Ĳ���С�������������룡");
			
		System.out.println(i+"+"+j+"="+(i+j));
		
	}

	private static void newIntAddMethod() {
		int i = 0;
		int j = 0;
		
		InputData input = new InputData();
		
		i = input.getInt("�������һ�����֣�", "����Ĳ������֣����������룡");
		j = input.getInt("������ڶ������֣�", "����Ĳ������֣����������룡");
		
		System.out.println(i+"+"+j+"="+(i+j));
	}

	private static void oldIntAddMethod() throws IOException {
		int i = 0;//��һ������
		int j = 0;//�ڶ�������
		
		BufferedReader buf = null;//���ռ��̵���������
		
		buf = new BufferedReader(new InputStreamReader(System.in));//ʵ����
		
		String str = null;//��������
		
		System.out.println("�������һ�����֣�");
		str = buf.readLine();//���յ�һ������
		i = Integer.parseInt(str);//�����յĵ�һ���ַ������ݣ�ת��������
		
		System.out.println("������ڶ������֣�");
		str = buf.readLine();//���յڶ�������
		j = Integer.parseInt(str);//�����յĵڶ����ַ������ݣ�ת��������
		
		System.out.println(i+"+"+j+"="+(i+j));
	}

}
