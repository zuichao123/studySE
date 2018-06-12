package cn.sunjian.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式操作练习：
 * 
 * 		验证一个日期格式的字符串是否合法
 * 
 * 			正则表达式
 * 
 * @author jack
 *
 */
public class RegexDemo3 {

	public static void main(String[] args) {
	
		String str = "1983-07-2sdf7";
		
		String pat = "\\d{4}-\\d{2}-\\d{2}";//指定好正则表达式
		
		Pattern p = Pattern.compile(pat);//实例化Pattern类
		
		Matcher m = p.matcher(str);//实例化Matcher类
		
		if (m.matches()) { 	//进行验证的匹配，使用正则
			System.out.println("日期格式合法！");
		}else {
			System.out.println("日期格式不合法！");
		}
	}

}
