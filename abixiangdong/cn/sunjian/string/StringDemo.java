package cn.sunjian.string;

/**
 * 
 * @author sunjian
 *
 */
public class StringDemo {

	public static void main(String[] args) {
		
		/*
		 * String 类的特点：
		 * 字符串对象一旦被初始化就不会被改变
		 */
		stringDemo1();
		stringDemo2();
	}

	public static void stringDemo2() {
		
		String string = "abc";//创建一个字符串对象在常量池中
		String string2 = new String("abc");//创建两个字符串对象，在堆内存中一个new，一个字符串对象
		//String类的equals方法复写Object类中的equals方法，建立了String类自己的判断字符串对象是否相同的依据。
		//其实就是比较字符串内容。
		System.out.println(string.equals(string2));
	}

	/**
	 * 演示String类
	 */
	private static void stringDemo1() {
		String string = "abc";
		String string2 = "abc";
		//string1和string2这两个String类类型的变量指向的是同一个地址。
		System.out.println(string == string2);
	}

}
