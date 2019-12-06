package cn.sunjian.exception;
/**
 * 异常处理练习
 * 
 * @author sunjian
 *
 */
public class ExceptionDemo {

	public static void main(String[] args) {
		System.out.println("计算开始。。。。。。。");
		int i = 10;
		int j = 0;
		
		try {
			int temp = i/j;//此处产生异常
			System.out.println("两个数相除="+temp);
			System.out.println("---------------");
		}catch(ArithmeticException e){//捕获算术异常
//			System.out.println(e);
			e.printStackTrace();
		}finally {
			System.out.println("异常的统一出口。。");
		}
		System.out.println("计算结束。。。。。。");
	}

}
