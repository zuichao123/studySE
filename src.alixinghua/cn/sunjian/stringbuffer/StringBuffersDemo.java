package cn.sunjian.stringbuffer;

/**
 * StringBuffer：
 * 		字符串连接操作
 * 
 * @author jack
 *
 */
public class StringBuffersDemo {

	public static void main(String[] args) {

		StringBuffer buf = new StringBuffer();//声明StringBuffer对象
		buf.append("hello");//向StringBuffer中添加内容
		buf.append("world").append("!!!");//可以连续调用append方法
		buf.append("\n");//添加一个转义字符
		buf.append("数字 = ").append(1).append("\n");//添加数字
		buf.append("字符 = ").append('C').append("\n");//添加字符
		buf.append("布尔 = ").append(true);//添加布尔值
		
		System.out.println(buf);//直接输出对象，调用toString()方法
		
	}

}
