package cn.sunjian.regex;

/**
 * 正则表达式操作练习：
 * 
 * 		String类对正则的支持：|的注意
 * 
 * 			正则表达式
 * 
 * @author jack
 *
 */
public class RegexDemo7 {

	public static void main(String[] args) {
	
		String str = "sunjian:98|jack:99|sun:97|jian:100";
		
		String s[] = str.split("\\|");//注意|在正则表达式中是一个逻辑运算符，表示或，所以在使用|分隔时要转义
		
		System.out.println("字符串拆分后：");
		for(int i=0;i<s.length;i++){
			String s2[] = s[i].split(":");//再根据:进行拆分
			System.out.println(s2[0]+"\t"+s2[1]);//将拆分后的两个字符进行输出
		}
		
	}

}
