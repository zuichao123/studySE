package cn.sunjian.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ������ʽ������ϰ��
 * 
 * 		ʹ��Matcher���е��ַ����滻����
 * 
 * 			������ʽ
 * 
 * @author jack
 *
 */
public class RegexDemo5 {

	public static void main(String[] args) {
	
		String str = "A15B223C333D44443E55555F";
		
		String pat = "\\d+";//ָ����������ʽ
		
		Pattern p = Pattern.compile(pat);//ʵ����Pattern��
		
		Matcher m = p.matcher(str);//ʵ����Matcher��Ķ���
		
		String newString = m.replaceAll("_");//ʹ��Matcher���е��滻���������滻
		
		System.out.println(newString);
		
	}

}
