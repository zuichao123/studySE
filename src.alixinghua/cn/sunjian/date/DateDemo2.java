package cn.sunjian.date;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * DateFormat����ϰ��
 * 
 * ʹ��DateFormat�����Date���ת�����ܣ�
 * 		public final String format(Date date);
 * 
 * @author jack
 *
 */
public class DateDemo2 {

	public static void main(String[] args) {

		DateFormat df1 = null;//����һ��DateFormat
		DateFormat df2 = null;

		df1 = DateFormat.getDateInstance(DateFormat.YEAR_FIELD,new Locale("zh", "CN"));//�õ����ڵ�DateFormat����
		df2 = DateFormat.getDateTimeInstance(DateFormat.YEAR_FIELD,DateFormat.ERA_FIELD,new Locale("zh", "CN"));//�õ�����ʱ���DateFormat����
		
		//�����Զ����ʽ������
		System.out.println("DATE��"+df1.format(new Date()));//�������ڸ�ʽ��
		System.out.println("DATETIME��"+df2.format(new Date()));//����ʱ���ʽ��
		
	}

}
