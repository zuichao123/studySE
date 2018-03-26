package com.sunjian.basicmethod.practice;

import java.util.Arrays;

/**
 * 给定一个有序的数组，如果往该数组中存储一个元素，并且保证该数组还是有序的，
 * 那么这个元素的存储的角标为：如何获取
 * @author sunjian
 *
 */
public class TestPricate1 {

	public static void main(String[] args) {
		int []arr = {1,2,3,4,5,6,7,8};
		System.out.println(Arrays.binarySearch(arr, 10));
	}
}
