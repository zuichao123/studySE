package cn.sunjian.date;

import java.text.DateFormat;
import java.util.Date;

/**
 * DateFormat����ϰ��
 * 
 * ʹ��DateFormat�����Date���ת�����ܣ�
 * 		public final String format(Date date);
 * 
 * @author jack
 *
 */
public class DateDemo {

	public static void main(String[] args) {

		DateFormat df1 = null;//����һ��DateFormat
		DateFormat df2 = null;

		df1 = DateFormat.getDateInstance();//�õ����ڵ�DateFormat����
		df2 = DateFormat.getDateTimeInstance();//�õ�����ʱ���DateFormat����
		
		//����Ĭ�ϸ�ʽ������
		System.out.println("DATE��"+df1.format(new Date()));//�������ڸ�ʽ��
		System.out.println("DATETIME��"+df2.format(new Date()));//����ʱ���ʽ��
		
		
	}

}
