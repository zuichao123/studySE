package cn.sunjian.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ������ʽ������ϰ��
 * 
 * 		��֤һ�����ڸ�ʽ���ַ����Ƿ�Ϸ�
 * 
 * 			������ʽ
 * 
 * @author jack
 *
 */
public class RegexDemo3 {

	public static void main(String[] args) {
	
		String str = "1983-07-2sdf7";
		
		String pat = "\\d{4}-\\d{2}-\\d{2}";//ָ����������ʽ
		
		Pattern p = Pattern.compile(pat);//ʵ����Pattern��
		
		Matcher m = p.matcher(str);//ʵ����Matcher��
		
		if (m.matches()) { 	//������֤��ƥ�䣬ʹ������
			System.out.println("���ڸ�ʽ�Ϸ���");
		}else {
			System.out.println("���ڸ�ʽ���Ϸ���");
		}
	}

}
