package cn.sunjian.string;

/**
 * 字符串与字符数组的转换
 * 
 * @author sunjian
 *
 */

public class StringAPIDemo01 {
	public static void main(String[] args) {
		String str = "hello";
		
		char[] c = str.toCharArray();//将字符串转成字符串数组
		
		for(int i=0;i<c.length;i++){
			System.out.print(c[i]+"、");
		}
		System.out.println();
		
		String str1 = new String(c);//将全部字符串数组，变成字符串
		String str2 = new String(c, 0, 2);//将部分字符数组，变成字符串
		
		System.out.println(str1);
		
		System.out.println(str2);
		
		System.out.println(str.charAt(3));//取出指定位置的字符串
	}

}
