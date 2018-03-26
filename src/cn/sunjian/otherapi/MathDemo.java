package cn.sunjian.otherapi;

import java.util.Random;

/**
 * Math: 提供了操作数学运算的方法。都是静态的。
 * 
 * @author sunjian
 *
 */
public class MathDemo {

	public static void main(String[] args) {

		/*
		 * 常用方法：
		 * ceil();返回大于参数的最小整数
		 * floor();返回小于参数的最小整数
		 * round();返回四舍五入的整数
		 * pow(a,b);a的b次方
		 * random();随机数
		 * 
		 */
		
		double d1 = Math.ceil(12.56);
		double d2 = Math.floor(12.56);
		double d3 = Math.round(12.56);
		
		sop("d1="+d1);
		sop("d2="+d2);
		sop("d3="+d3);
		
		double d = Math.pow(10, 2);
		sop("d="+d);
		
		Random r = new Random();
		for(int i=0; i<10; i++){
			double dd = (int)(Math.random()*6+1);
			double ddd = (int)(r.nextDouble()*6+1);
			int dddd = r.nextInt(6)+1;
//			System.out.println(dd);
//			System.out.println(ddd);
			System.out.println(dddd);
		}
		
	}

	public static void sop(String string) {
		System.out.println(string);
	}

}
