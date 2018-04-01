package cn.sunjian.string;
/**
 * 模擬一個trim功能一致的方法；
 * 去除字符串兩頭的空格
 * 
 * 思路：
 * 1.定義兩個變量；
 * 		一個作為從頭開始判斷字符串空格的角標，不斷++；
 * 		一個作為從尾開始判斷字符串空格的角標，不斷--；
 * 2.判斷到不是空格為止，取頭尾之間的字符串角標即可。
 * 
 * @author sunjian
 *
 */
public class StringTrim {

	public static void main(String[] args) {

		String s = "     ab   c    ";
		
		s = myTrim(s);
		
		System.out.println(s);
	}

	public static String myTrim(String s) {
		
		int start = 0;
		int end = s.length()-1;
		
		while(start<=end && s.charAt(start)==' '){
			start++;
		}
		while(start<=end && s.charAt(end)==' '){
			end--;
		}
		return s.substring(start, end+1);
	}

}
