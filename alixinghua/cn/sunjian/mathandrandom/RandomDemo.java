package cn.sunjian.mathandrandom;

import java.util.Random;

/**
 * Random类操作练习：
 * 
 * 		生成10个随机数，且数字不大于100
 * 
 * @author sunjian
 *
 */
public class RandomDemo {
	public static void main(String[] args) {
		Random r = new Random();//实例化random对象
		
		for(int i=0;i<10;i++){
			System.out.print(r.nextInt(100)+" ");
		}
	}
}
