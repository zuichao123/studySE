package cn.sunjian.junit;

import org.junit.Assert;
import org.junit.Test;


public class MyMathDemoTest {

	@Test
	public void test() {
		try {
			Assert.assertEquals(new MyMathDemo().div(10, 5), 2);//断言测试div()方法的结果
			System.out.println("10/5=2");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			Assert.assertEquals(new MyMathDemo().div(10, 3), 3, 1);//断言div()方法的结果
			System.out.println("10/3的结果：等于3余1");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
