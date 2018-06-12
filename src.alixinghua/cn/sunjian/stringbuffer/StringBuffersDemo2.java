package cn.sunjian.stringbuffer;

/**
 * StringBuffer：
 * 		StringBuffer对象引用传递
 * 
 * @author jack
 *
 */
public class StringBuffersDemo2 {

	public static void main(String[] args) {
		StringBuffer buf = new StringBuffer();
		
		buf.append("Hello");
		
		fun(buf);
		
		System.out.println(buf);
	}

	private static void fun(StringBuffer buf) {

		buf.append("sunjian").append("123");
	}

}
