package cn.sunjian.string;

/**
 * 兩個字符串中最大相同的字串
 * 
 * “qwerabcdtyuiop”
 * “xcabcdvbn”
 * 
 * 思路：
 * 1.既然取得是最大字串，先看短的那個字符串是否在長的那個字符串中
 * 	 如果存在，短的那個字符串就是大字串
 * 2.如果不是呢，那麼就將短的那個字串進行長度遞減的方式去字串，去長串中判斷是否存在
 * 	 如果存在就已找到，就不用再找了。
 * 
 * @author sunjian
 *
 */

public class StringMaxSame {

	public static void main(String[] args) {

		String s1 = "qwerabcdtyuiop";
		String s2 = "xcabcdvbn";
		
		String s = getMaxSubstring(s1, s2);
		System.out.println("最大相同的字串="+s);
	}

	public static String getMaxSubstring(String s1, String s2) {
		
		String max = null; 
		String min = null;
		max = (s1.length()>s2.length())?s1:s2;
		min = max.equals(s1)?s2:s1;
		
		System.out.println("max="+max);
		System.out.println("min="+min);
		
		for(int i = 0; i<min.length(); i++){
			
			for(int a = 0, b = min.length()-i; b!=s2.length()+1;  a++,b++){
				
				String sub = min.substring(a, b);
//				System.out.println(sub);
				if (max.contains(sub)) {
					return sub;
				}
			}
		}
		
		return null;
	}

}
