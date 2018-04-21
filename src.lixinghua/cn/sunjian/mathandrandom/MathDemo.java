package cn.sunjian.mathandrandom;

/**
 * Math类操作练习：
 * 
 * @author sunjian
 *
 */
public class MathDemo {
	public static void main(String[] args) {
		//Math类中的方法都是静态方法，直接使用“类.方法名称()”的形式调用即可
		
		System.out.println("求8.0的平方根："+Math.sqrt(8.0));
		System.out.println("求两数的最大值："+Math.max(1, 40));
		System.out.println("求两数的最小值："+Math.min(1, 40));
		System.out.println("求2的3次方："+Math.pow(2, 3));
		System.out.println("四舍五入："+Math.round(33.6));
	
		/*
		 * 以上代码四舍五入时，是将小数点后的内容全部忽略掉了，
		 * 如果此时需要进行准确位数的四舍五入，则需要使用其他的类完成====BigDecimal.
		 */
		
	}
}
