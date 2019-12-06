package cn.sunjian.string;

/**
 * 字符串与byte数组的转换
 * 
 * 还有一些其他方法
 */
public class StringAPIDemo02 {

	public static void main(String[] args) {
		String str1 = "   hello world!    ";
		String str = "HELLO WORLD!";
		String str2 = "hello world!";
		
		byte[] b = str1.getBytes();//字符串变为字节数组
		
		System.out.println(new String(b));//将全部的字节数组变为字符串
		
		System.out.println(new String(b, 1, 3));//将部分字节数组变为字符串
		
		System.out.println(str1.length());//取得字符串的长度
	
		System.out.println(str1.indexOf("w"));//查找字符在字符串中的位置
		
		System.out.println(str1.indexOf("o",5));//从字符串中的第五个位置处开始查找o出现的位置
		
		System.out.println(str1.indexOf("x"));//么有查到是返回-1
	
		System.out.println(str1.trim());//去掉左右两端的空格后输出
	
		System.out.println(str1.substring(6));//从第7个位置开始截取输出
		
		System.out.println(str1.substring(6, 10));//截取第6到10个位置的内容
	
		System.out.println(str1.toUpperCase());//将字符串转成大写输出
		
		System.out.println(str.toLowerCase());//将字符串转成小写输出
		
		//按空格对字符串进行拆分,并输出
		String s[] = str1.split(" ");
		for(int i=0;i<s.length;i++){
			System.out.println(s[i]);
		}
	
		//判断字符串是否以指定的字符开头和结尾
		if(str.startsWith("*")){
			System.out.println(str);
		}
		if(str.endsWith("*")){
			System.out.println(str);
		}
		
		//判断字符串内容是否相同
		System.out.println(str.equals(str2));//区分大小写
		System.out.println(str.equalsIgnoreCase(str2));//不区分大小写
	
		//字符串替换操作
		System.out.println(str2.replaceAll("l", "x"));
		
	}
}
