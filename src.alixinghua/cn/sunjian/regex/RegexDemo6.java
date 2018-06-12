package cn.sunjian.regex;

/**
 * 正则表达式操作练习：
 * 
 * 		String类对正则的支持
 * 
 * 			正则表达式
 * 
 * @author jack
 *
 */
public class RegexDemo6 {

	public static void main(String[] args) {
	
		String str = "A15B223C333D44443E55555F".replaceAll("\\d+","_");
		
		boolean temp = "1983-07-27".matches("\\d{4}-\\d{2}-\\d{2}");
		
		String s[] = "A15B223C333D44443E55555F".split("\\d+");
		
		System.out.println("字符串替换操作："+str);
		
		System.out.println("字符串验证："+temp);
		
		System.out.print("字符串拆分：");
		for(int i=0;i<s.length;i++){
			System.out.print(s[i]+"\t");
		}
				
	}

}
