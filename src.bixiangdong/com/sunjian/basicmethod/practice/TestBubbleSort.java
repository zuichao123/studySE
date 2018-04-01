package com.sunjian.basicmethod.practice;

import java.util.Arrays;

/**
 * pricate Bubble Sort
 * @author sunjian
 *
 */
public class TestBubbleSort {
	
	public static void main(String[] args){
		int [] arr = {9,8,7,6,5,4,3,2,1};
		youHuaBubbleSort(arr);
		System.out.println("##############################################");
		arr =new int[] {9,8,7,6,5,4,3,2,1};
		finalBubbleSort(arr);
	}
	
	//优化冒泡排序
	public static void youHuaBubbleSort(int[] arr){
		for(int j=0;j<arr.length-1;j++){
			System.out.println("第"+(j+1)+"趟");
			for(int i=0; i<arr.length-1;i++){
				System.out.print("第"+(i+1)+"次");
				if(arr[i]>arr[i+1]){
					int temp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = temp;
				}
				System.out.println(Arrays.toString(arr));
			}
		}
	}
	//终极冒泡排序
	public static void finalBubbleSort(int[] arr){
		int leng = arr.length;
		boolean aaa = true;
		for(int j=0;j<leng-1;j++){
			System.out.println("第"+(j+1)+"趟");
			aaa = true;
			for(int i=0;i<leng-1-j;i++){
				System.out.print("第"+(i+1)+"次");
				if(arr[i]>arr[i+1]){
					int temp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = temp;
					aaa = false;
				}
				System.out.println(Arrays.toString(arr));
			}
			if(aaa){
				break;
			}
		}
	}	
}
