package cn.sunjian.otherapi;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * date �� ������
 * 
 * @author sunjian
 *
 */
public class DateDemo {

	public static void main(String[] args) throws ParseException {
		
//		methodDemo_1();
		
//		methodDemo_2();
		
		methodDemo_3();
		
	}
	
	
	/*
	 *�����ڸ�ʽ���ַ���ת�������ڶ���
	 * 
	 * ʹ�õ���DateFormat�е�parse()������
	 */
	public static void methodDemo_3() throws ParseException {
		
		String str_date = "2018��01��04��";
		str_date = "2018---02---05";
		
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG);
		
		dateFormat = new SimpleDateFormat("yyyy---MM---dd");
		
		Date date = dateFormat.parse(str_date);
		
		System.out.println(date);
	}

	/*
	 * �����ڶ�����и�ʽ��
	 * �����ڶ���ת�������ڸ�ʽ���ַ���
	 * ʹ�õ���DateFormat�е�format������
	 */
	public static void methodDemo_2() {
		
		Date date = new Date();
		
		//��ȡ���ڸ�ʽ���󣬾�����Ĭ�ϵķ��FULL LONG����ָ�����
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG);
		dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG);
		
		
		//���������Զ�����ģ��������أ�
		dateFormat = new SimpleDateFormat("yyyy--MM--dd");
		
		String str_date = dateFormat.format(date);
		
		System.out.println(str_date);
	
	}

	/**
	 * ����ǰ���ں�ʱ���װ��date����
	 */
	public static void methodDemo_1() {
		@SuppressWarnings("unused")
		long time = System.currentTimeMillis();
//		System.out.println(time);
		
		Date date = new Date();//����ǰ���ں�ʱ���װ��date����
		System.out.println(date);
		
//		Date date2 = new Date(15148162706900);//��ָ������ֵ��װ��date����
//		System.out.println(date2);
	}

	/**
	 * ���ڶ���ͺ���ֵ֮���ת��
	 * 
	 * ����ֵ-->���ڶ���
	 * 	1.ͨ��Date����Ĺ��췽��new Date(timeMillis);
	 *  2.������ͨ��setTime����
	 *  ��Ϊ����ͨ��Date����ķ����Ը������еĸ����ֶΣ������յȣ����в�����
	 *  
	 *  ���ڶ���-->����ֵ��
	 *   1.getTime����
	 *   ��Ϊ����ͨ���������ֵ�������㡣
	 *  
	 *  
	 */
	
	
}
