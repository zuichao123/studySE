package cn.sunjian.junit;

import org.junit.Assert;
import org.junit.Test;


public class MyMathDemoTest {

	@Test
	public void test() {
		try {
			Assert.assertEquals(new MyMathDemo().div(10, 5), 2);//���Բ���div()�����Ľ��
			System.out.println("10/5=2");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			Assert.assertEquals(new MyMathDemo().div(10, 3), 3, 1);//����div()�����Ľ��
			System.out.println("10/3�Ľ��������3��1");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
