package cn.sunjian.regex;

import java.util.regex.Pattern;

/**
 * ������ʽ������ϰ��
 * 
 * 		ʹ��Pattern������ַ����Ĳ��
 * 
 * 			������ʽ
 * 
 * @author jack
 *
 */
public class RegexDemo4 {

	public static void main(String[] args) {
	
		String str = "A15B223C333D44443E55555F";
		
		String pat = "\\d+";//ָ����������ʽ
		
		Pattern p = Pattern.compile(pat);//ʵ����Pattern��
		
		String s[] = p.split(str);//ִ�в�ֲ���
		
		for(int x=0;x<s.length;x++){
			System.out.print(s[x]+"\t");
		}
		
	}

}
