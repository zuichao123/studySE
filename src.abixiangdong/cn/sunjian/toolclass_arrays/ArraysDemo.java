package cn.sunjian.toolclass_arrays;

import java.util.Arrays;
import java.util.List;

/**
 * 集合框架的工具类===Arrays
 * @author sunjian
 *
 */
public class ArraysDemo {

	public static void main(String[] args) {

		/**
		 * 重点：List asList（数组）将数组转成集合。
		 * 
		 * 好处：其实可以使用集合的方法操作数组中的元素。
		 * 注意：数组的长度是固定的，所以对于集合的增删方法是不可以使用的；否则会发生UnsupportedOperationException
		 * 
		 */
		
		String [] arr = {"abc","haha","xixi"};
		
		List<String> list = Arrays.asList(arr);
		
		System.out.println(list);
		
		int[] arr1 = {42,45,83,90};
		demo_1(arr1);
		
	}

	private static void demo_1(int[] arr1) {
		List<int[]> list = Arrays.asList(arr1);
		System.out.println(list);
	}

}
