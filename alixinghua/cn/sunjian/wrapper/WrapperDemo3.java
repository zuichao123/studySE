package cn.sunjian.wrapper;
/**
 * 包装类
 * 
 * 将一个由数字组成的字符串，转成int/float数据类型
 * 
 * @author sunjian
 *
 */
public class WrapperDemo3 {

	public static void main(String[] args) {
	
		String str = "123456";
		String str2 = "123.456";
		
		int x = Integer.parseInt(str);
		float y = Float.parseFloat(str2);
		
		System.out.println(x);
		System.out.println(y);
		
	}

}
