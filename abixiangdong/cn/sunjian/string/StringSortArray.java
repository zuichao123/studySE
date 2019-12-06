package cn.sunjian.string;

/**
 * 给定一个字符串数组，按照字典顺序进行从小到大的排序。
 * {"nba","abc","cba","zz","qq","haha"}
 * 
 * 思路：
 * 1.对数组排序，可以用选择、冒泡；
 * 2.for嵌套和比较以及换位；
 * 3.比较字符串对象；
 * 
 * @author sunjian
 *
 */
public class StringSortArray {

	public static void main(String[] args) {
		
		String [] arr = {"nba","abc","cba","zz","qq","haha"};
		
		//打印数组
		printArray(arr);
		
		//排序字符串
		sortString(arr);
		
		//打印数组
		printArray(arr);
	}

	public static void sortString(String[] arr) {
		
		for (int i = 0; i < arr.length-1; i++) {
			for (int j = i+1; j < arr.length-1; j++) {
				if (arr[i].compareTo(arr[j])>0) {//字符串比較用compareTo方法完成
					swap(arr, i, j);
				}
			}
		}
	}

	private static void swap(String[] arr, int i, int j) {
		
		String temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;				
	}

	//打印數組方法
	public static void printArray(String[] arr) {
		System.out.print("[");
		for (int i = 0; i < arr.length; i++) {
			if (i!=arr.length-1)
				System.out.print(arr[i]+", ");
			else
				System.out.println(arr[i]+"]");
		}
	}

	

	

	
	

}
