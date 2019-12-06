package cn.sunjian.wrapperclass;

/**
 * 练习包装类的使用
 * 
 * @author sunjian
 *
 */
public class WrapperClassDemo {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		int num = 4;
		
//		System.out.println(Integer.MAX_VALUE);
//		System.out.println(Integer.toBinaryString(-6));
		
		
		num += 5;
		
		Integer i = 4;
		i = i + 6;
		
		show(55);
		
		
		Integer a = new Integer(128);
		Integer b = new Integer(128);
		
		System.out.println(a==b);//false
		System.out.println(a.equals(b));//true
		
		Integer x = 127;
		Integer y = 127;
		
		System.out.println(x==y);//true,jdk1.5以后，自动装箱，如果装箱的是一个字节，那么该数据会被共享不会重新开辟空间。
		System.out.println(x.equals(y));//true
	}

	public static void show(Object a) {
		System.out.println("a="+a);
	}

}
