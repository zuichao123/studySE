package cn.sunjian.regex.demo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * 正则表达式
 */
public class RegexDemo2 {

	public static void main(String[] args) {

		/*
		 * 正则表达式对字符串的常见操作：
		 * 	1，匹配
		 * 		其实使用的就是String类中的matches方法。
		 *  2，切割
		 *  	其实就是String累的split方法。
		 *  3，替换
		 *  	其实使用的就是String类中的replaceAll()方法。
		 *  
		 *  4，获取
		 *  		
		 */
		
		functionDemo_4();
		
	}
	
	/*
	 * 获取演示
	 * 
	 * 将正则规则进行对象的封装。
	 * Pattern p = Pattern.compile("a*b");
	 * 通过正则对象的matcher方法字符串相关联。获取要对字符串操作的匹配器对象Matcher
	 * Matcher m = p.matcher("aaaaab");
	 * 通过Matcher匹配器对象的方法对字符串进行操作。
	 * boolean b = m.matches();
	 * 
	 */

	public static void functionDemo_4() {
		
		String str = "da jia hao, ming tian bu fang jia!";
		
		String regex = "\\b[a-z]{3}\\b";//字母出现3次;反斜杠b代表字母边界
		
		//1，将正则封装成对象。
		Pattern p = Pattern.compile(regex);
		//2，通过正则对象获取匹配器对象。
		Matcher m = p.matcher(str);
		
		//使用Match而对象的方法对字符串进行操作。
		//既然要获取三个字符组成的单词。
		//查找。find();
		
		System.out.println(str);
		while(m.find()){
			System.out.println(m.group());//获取匹配的子序列。
			
			System.out.println(m.start()+":"+m.end());
		}
		
	}


	/*
	 * 替换演示
	 * 
	 */
	public static void functionDemo_3() {
		String str = "zhangsanttttxiaoqiangmmmmmzhaoliu";
//		str = str.replaceAll("(.)\\1+", "#");//把叠词替换成#号
		str = str.replaceAll("(.)\\1+", "$1");//把已有正则规则中的叠词获取，换成一个叠词
	
		System.out.println(str);
		
		String tel = "15800001111";//158****1111
		
		tel = tel.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");//头尾两组留下，中间部分替换为*
		
		System.out.println(tel);
		
	}
	
	
	
	
	
	
	
	
	
	/*
	 * 切割演示
	 * 
	 * 组：((A)(B(C)))
	 * 
	 */
	public static void functionDemo_2(){
		
//		String str = "zhangsan     xiaoqiang     zhaoliu";
//		String str1 = "zhangsan.xiaoqiang.zhaoliu";
		String str2 = "zhangsanttttxiaoqiangmmmmmmmzhaoliu";
		
//		String [] names = str.split(" +");//空格出现一次或多次
//		String [] names = str1.split("\\.");//"\\."点事特殊字符，所以要转义
		String [] names = str2.split("(.)\\1+");//用（）小括号封装成函数;意思是：第一组内容是.任意，而且不止出现1次
											    //(.)将任意字符用小括号封装成函数
												//\\1将数字1转义成1代表，第一组
												//+代表这个任意字符不止出现一次
		
		for(String name:names){
			System.out.println(name);
		}
		
	}
	
	
	/*
	 * 演示匹配
	 */
	public static void functionDemo_1(){
		
		//匹配手机号码是否正确
		String tel = "15800001111";
		
//		String regex = "1[358][0-9]{9}";
		String regex = "1[358]\\d{9}";
		
		boolean b = tel.matches(regex);
		System.out.println(tel+":"+b);
		
	}

	
}
