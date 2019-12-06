package cn.sunjian.date;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ����SimpleDate��Ĳ�����
 * 		��ȡϵͳʱ��
 * 		��ȡʱ���
 * 	
 *   java.util.Date�Ѿ���һ�������������ˣ�SimpleDate���д���һ��������
 *   ���������Date���¸�ʽ������ô������ڽ�һ����ʾ��ǰ���ڵ�date����SimpleDateFormat��ָ���õ�ģ�������صĸ�ʽ�������Ļ���
 *   ��ôȡ��ʱ��ͷǳ������ˡ�
 * 	
 * @author sunjian
 *
 */

class DateTime2{
	
	private SimpleDateFormat sdf = null;//����һ��SimpleDateFormat����
	
	/*
	 * ���巽����getDate
	 * 	 �õ�һ�����ڣ���ʽΪ��
	 * 		yyyy-MM-dd HH:mm:ss.SSS
	 */
	public String getDate(){
		
		this.sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		
		return this.sdf.format(new Date());//����ǰ���ڽ��и�ʽ������
	}
	/*
	 * ���巽����getDateComplete
	 * 		�õ�һ������,��ʽΪ��
	 * 			yyyy��MM��dd��HHʱmm��ss��SSS����
	 */
	public String getDateComplete(){
		
		this.sdf = new SimpleDateFormat("yyyy��MM��dd��HHʱmm��ss��SSS����");
		
		return this.sdf.format(new Date());//����ǰ���ڽ��и�ʽ������

	}
	/*
	 * ���巽����getTimeStamp
	 * 		�õ�һ��ʱ���
	 */
	public String getTimeStamp(){
		
		this.sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		
		return this.sdf.format(new Date());//����ǰ���ڽ��и�ʽ������
	}

}

public class SimpleDateFormatDemo {

	public static void main(String[] args) {
		
		DateTime2 dt2 = new DateTime2();
		
		System.out.println("ϵͳʱ�䣺"+dt2.getDate());
		System.out.println("����ϵͳʱ�䣺"+dt2.getDateComplete());
		System.out.println("ʱ�����"+dt2.getTimeStamp());

	}

}
