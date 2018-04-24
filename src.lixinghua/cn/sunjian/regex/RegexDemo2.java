package cn.sunjian.regex;

import java.util.regex.Pattern;

/**
 * 正则表达式操作练习：
 * 
 * 		判断一个字符串是否有数字组成
 * 
 * 			正则表达式
 * 
 * @author jack
 *
 */
public class RegexDemo2 {

	public static void main(String[] args) {
	
		String str = "1234567890";
		
		if (Pattern.compile("[0-9]+").matcher(str).matches()) {//使用正则
			System.out.println("是由数字组成！");
		}else {
			System.out.println("不是由数字组成！");
		}
	}

}
