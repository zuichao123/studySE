package cn.sunjian.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式操作练习：
 * 
 * 		使用Matcher类中的字符串替换方法
 * 
 * 			正则表达式
 * 
 * @author jack
 *
 */
public class RegexDemo5 {

	public static void main(String[] args) {
	
		String str = "A15B223C333D44443E55555F";
		
		String pat = "\\d+";//指定好正则表达式
		
		Pattern p = Pattern.compile(pat);//实例化Pattern类
		
		Matcher m = p.matcher(str);//实例化Matcher类的对象
		
		String newString = m.replaceAll("_");//使用Matcher类中的替换方法进行替换
		
		System.out.println(newString);
		
	}

}
