package cn.sunjian.date;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * SimpleDateFormat�࣬��ϰ��
 * 
 * @author jack
 *
 */
public class DateDemo3 {

	public static void main(String[] args) {

		String strDate = "2018-04-20 08:33:30.456";
		
		//׼����һ��ģ�壬���ַ�������ȡ�������֣���������ʾ���ַ������ڸ�ʽ������ģ�飬������ȡ�ṩ���ַ��е����ڣ�
		String pat1 = "yyyy-MM-dd HH:mm:ss.SSS";
		
		//׼���ڶ���ģ�壬����ȡ����������ֱ�Ϊָ���ĸ�ʽ
		String pat2 = "yyyy��MM��dd�� HHʱmm��ss��SSS����";
		
		//ʵ����ģ��
		SimpleDateFormat sdf1 = new SimpleDateFormat(pat1);
		SimpleDateFormat sdf2 = new SimpleDateFormat(pat2);
		
		//����ʱ�����
		Date date = null;
		
		try {
			date = sdf1.parse(strDate);//���������ַ����е�������ȡ����
		} catch (Exception e) {		   //�����ȡ���ַ�����ʽ����������쳣����
			e.printStackTrace();	   //��ӡ�쳣��Ϣ
		}
		
		//�����ڱ�Ϊ�µĸ�ʽ
		System.out.println(sdf2.format(date));
		
		
	}

}
