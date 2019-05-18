package cn.itcast.subString;

public class SubStringDemo {
	
	public static void main(String[] args) {
		String str = "C:\\Users\\sunjian\\desktop\\a.txt";
		String str2 = "b.txt";

		System.out.println(str.substring(str.lastIndexOf("\\")));//返回最后一个“\\”以后的所有字符，包含“\\”
		System.out.println(str.substring(str.lastIndexOf("\\")+1));//返回最后一个“\\”以后的所有字符，不包含“\\”
		System.out.println(str2.substring(str2.lastIndexOf("\\")+1));//返回第0个字符
		
		
		System.out.println(str.substring(str.indexOf("\\")));
		System.out.println(str.substring(3));
	}

}
