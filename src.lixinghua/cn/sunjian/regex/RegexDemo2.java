package cn.sunjian.regex;

import java.util.regex.Pattern;

/**
 * ������ʽ������ϰ��
 * 
 * 		�ж�һ���ַ����Ƿ����������
 * 
 * 			������ʽ
 * 
 * @author jack
 *
 */
public class RegexDemo2 {

	public static void main(String[] args) {
	
		String str = "1234567890";
		
		if (Pattern.compile("[0-9]+").matcher(str).matches()) {//ʹ������
			System.out.println("����������ɣ�");
		}else {
			System.out.println("������������ɣ�");
		}
	}

}
