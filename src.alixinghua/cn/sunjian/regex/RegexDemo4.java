package cn.sunjian.regex;

import java.util.regex.Pattern;

/**
 * 正则表达式操作练习：
 * 
 * 		使用Pattern类进行字符串的拆分
 * 
 * 			正则表达式
 * 
 * @author jack
 *
 */
public class RegexDemo4 {

	public static void main(String[] args) {
	
		String str = "A15B223C333D44443E55555F";
		
		String pat = "\\d+";//指定好正则表达式
		
		Pattern p = Pattern.compile(pat);//实例化Pattern类
		
		String s[] = p.split(str);//执行拆分操作
		
		for(int x=0;x<s.length;x++){
			System.out.print(s[x]+"\t");
		}
		
	}

}
