package cn.sunjian.arrsys;

import java.util.Arrays;

/**
 * Arrays类操作练习：
 * 
 * 		常用方法练习
 * 
 * @author sunjian
 *
 */
public class ArraysDemo {

	public static void main(String[] args) {

		int[] temp = {2,6,464564,234,7,58,1,9};
		
		Arrays.sort(temp);//数组排序
		System.out.println("排序后的数组："+Arrays.toString(temp));
	
		//如果想要使用二分法查找的话，必须是排序后的数组
		int point = Arrays.binarySearch(temp, 7);//检索位置
		System.out.println("元素7的位置："+point);
		
		Arrays.fill(temp, 3456);//数组填充
		System.out.println("填充后的数组："+Arrays.toString(temp));
		
	}

}
