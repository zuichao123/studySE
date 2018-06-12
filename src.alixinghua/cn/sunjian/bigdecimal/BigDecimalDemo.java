package cn.sunjian.bigdecimal;

import java.math.BigDecimal;

/**
 * BigDecimal类操作练习：大小数
 * 	
 * @author sunjian
 *
 */
class MyMath{
	public static double add(double d1,double d2){//加法
		BigDecimal b1 = new BigDecimal(d1);
		BigDecimal b2 = new BigDecimal(d2);
		
		return b1.add(b2).doubleValue();
	}
	public static double sub(double d1,double d2){//减法操作
		BigDecimal b1 = new BigDecimal(d1);
		BigDecimal b2 = new BigDecimal(d2);

		return b1.subtract(b2).doubleValue();
	}
	public static double mul(double d1,double d2){//乘法
		BigDecimal b1 = new BigDecimal(d1);
		BigDecimal b2 = new BigDecimal(d2);

		return b1.multiply(b2).doubleValue();
	}
	public static double div(double d1,double d2,int len){//除法,并指定保留小数点后的位数
		BigDecimal b1 = new BigDecimal(d1);
		BigDecimal b2 = new BigDecimal(d2);

		return b1.divide(b2, len,BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	public static double round(double d,int len){//四舍五入,并指定好小数点后的个数
		BigDecimal b1 = new BigDecimal(d);
		BigDecimal b2 = new BigDecimal(1);
		
		return b1.divide(b2, len,BigDecimal.ROUND_HALF_UP).doubleValue();
	}
}

public class BigDecimalDemo {

	public static void main(String[] args) {
	
		System.out.println("加法："+MyMath.add(10.345, 3.333));
		System.out.println("减法："+MyMath.sub(10.345, 3.333));
		System.out.println("乘法："+MyMath.mul(10.345, 3.333));
		System.out.println("除法："+MyMath.div(10.345, 3.333,3));
		System.out.println("四舍五入："+MyMath.round(10.345,2));
		
	}

}
