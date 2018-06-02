package cn.sunjian.useradmin.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ����һ�����������ࣺ
 * 
 * 		�ж������������ʲô���ͣ��Ӷ�����ָ����Ҫ����в�����		
 * 
 * @author sunjian
 *
 */
public class InputData {
	
	BufferedReader buf = null;//���ռ�������������Ϣ����
	
	public InputData(){//���췽����ʵ����BufferedReader����
		this.buf = new BufferedReader(new InputStreamReader(System.in));
	}

	//��ȡ�ַ�����Ϣ
	public String getString(String info){
		String temp = null;//���ն�ȡ����Ϣ
		System.out.print(info);
		try {
			temp = this.buf.readLine();//��ȡ����¼�����Ϣ��һ�ζ�ȡһ��
		} catch (IOException e) {
			e.printStackTrace();
		}
		return temp;
	}
	
	//��ȡ��������
	public int getInt(String info,String err){
		int temp = 0;//���ڴ����������
		String str = null;//���ն�ȡ������
		boolean flag = true;//����һ�����
		
		while(flag){			
			str = this.getString(info);//��������
			if (str.matches("^\\d+$")) {//������ʽ�жϣ�����������Ƿ�Ϊ����
				temp = Integer.parseInt(str);//�����յ��ַ�������ת������������
				flag = false;//����ѭ��
			}else {
				System.out.println(err);//���򣬴�ӡ������Ϣ
			}
		}
		return temp;
	}
	
	//��ȡ����������
	public float getFloat(String info,String err){
		float temp = 0;//���ڴ��С������
		String str = null;//���ն�ȡ������
		boolean flag = true;//����һ�����λ
		
		while(flag){
			str = this.getString(info);//��������^\\d+.?\\d+$
			if (str.matches("^\\d+.?\\d+$")) {//������ʽ�жϣ�����������Ƿ�ΪС��
				temp = Float.parseFloat(str);//�����ܵ�����ת��С��
				flag = false;//����ѭ��
			}else {
				System.out.println(err);//��ӡ������Ϣ
			}
		}
		return temp;
	}
	
	//��ȡ���ڸ�ʽ������
	public Date getDate(String info,String err){
		Date temp = null;//���ڴ����������
		String str = null;//���ն�ȡ������
		boolean flag = true;//����һ�����λ
		
		while(flag){
			str = this.getString(info);//��������
			if (str.matches("^\\d{4}-\\d{2}-\\d{2}$")) {//������ʽ�жϣ�����������Ƿ�Ϊ����
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//������������ڸ�ʽ
				try {
					temp = sdf.parse(str);//�����յ��ַ�������ת��������
				} catch (ParseException e) {			
					e.printStackTrace();
				}
				flag = false;//����ѭ��
			}else {
				System.out.println(err);//��ӡ������Ϣ
			}
		}
		return temp;
	}
	
}
