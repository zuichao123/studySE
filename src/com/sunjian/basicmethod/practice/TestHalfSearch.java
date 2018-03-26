package com.sunjian.basicmethod.practice;

/**
 * 练习二分法查找
 * 
 * @author sunjian
 *
 */
public class TestHalfSearch {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
		int index = selfSearch(arr, 4);
		System.out.println(index);
		System.out.println(arr[index]);
	}

	public static int selfSearch(int[] arr, int key) {
		int min, max, mid;
		min = 0;
		max = arr.length - 1;

		while (min <= max) {

			mid = (min + max) >> 1;

			if (key > arr[mid]) {
				min = mid + 1;
			} else if (key < arr[mid]) {
				max = mid - 1;
			} else {
				return mid;
			}
		}
		return -1;
	}
}
