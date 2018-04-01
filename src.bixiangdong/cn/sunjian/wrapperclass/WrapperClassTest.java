package cn.sunjian.wrapperclass;

import java.util.Arrays;

/**
 * 练习包装类
 * 
 * @author sunjian
 *
 */

/**
 * 对一个字符串中的数值进行从小到大的排序。
 * “120 718 19 -7 818 361 29 4 0 11”
 * 
 * 思路：
 * 1.如何获取到这个字符串中的这些需要排序的数值？
 * 		发现这些数值都是使用空格来分隔的；
 * 		所有就用字符串对象的切割方法将大串变成多个小串；
 * 2.数值变成小字符串后，如何变成一个int数呢？
 * 		字符串-->基本数据类型：使用包装类。
 * 
 * @author sunjian
 *
 */
public class WrapperClassTest {

	private static final String SPACE_SEPARATOR = " ";
	
	public static void main(String[] args) {
		
		String numStr = "120 718 19 -7 818 361 29 4 0 11";
		
		System.out.println(numStr);
		numStr = sortStringNumber(numStr);
		System.out.println(numStr);

	}

	public static String sortStringNumber(String numStr) {
		
		//1.将字符串变成字符串数组
		String[] str_arr = stringToArray(numStr); 
		
		//2.将字符串数组变成int数组
		int[] int_arr = toIntArray(str_arr);
		
		//3.对int数组排序
		mySortArray(int_arr);
		
		//4.将排序后的int型数组变成字符串
		String str = arrayToString(int_arr);
		
		return str;
	}

	public static void mySortArray(int[] int_arr) {
		Arrays.sort(int_arr);
	}

	public static String arrayToString(int[] int_arr) {
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < int_arr.length; i++) {
			if (i!=int_arr.length-1) {
				sb.append(int_arr[i]+SPACE_SEPARATOR);
			}else {
				sb.append(int_arr[i]);
			}
		}
		
		return sb.toString();
	}

	public static int[] toIntArray(String[] str_arr) {
		
		//定义一个与字符串数组相同大小的int型数组
		int[] arr = new int[str_arr.length];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(str_arr[i]);
		}
		return arr;
	}

	public static String[] stringToArray(String numStr) {
		
		String[] str_arr = numStr.split(SPACE_SEPARATOR);
		return str_arr;
	}

}
