package cn.sunjian.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * DateFormat����ϰ��
 * 
 * ʹ��DateFormat�����Date���ת�����ܣ�
 * 		public final String format(Date date);
 *			��ȡ���ڸ�ʽ����(�Զ����ʽ����)
 * 
 * @author jack
 *
 */

public class GetDateDemo{
	public static void main(String[] args)throws ParseException{
	
		Date date = new Date();

		System.out.print("��ʽ��֮ǰ�����ڣ�"+date+"\n");
		
		//��ȡ���ڸ�ʽ����(�Զ������ڸ�ʽ)
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		
		//��ӡ����
		System.out.println("��ʽ��֮������ڣ�"+dateFormat.format(date));
	
	}
}