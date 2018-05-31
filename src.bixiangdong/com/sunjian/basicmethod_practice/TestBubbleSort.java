package com.sunjian.basicmethod_practice;

import java.util.Arrays;

/**
 * pricate Bubble Sort
 * 
 * 		√∞≈›≈≈–Ú£∫
 * 
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
	
	//”≈ªØ√∞≈›≈≈–Ú
	public static void youHuaBubbleSort(int[] arr){
		for(int j=0;j<arr.length-1;j++){
			System.out.println("µ⁄"+(j+1)+"ÃÀ");
			for(int i=0; i<arr.length-1;i++){
				System.out.print("µ⁄"+(i+1)+"¥Œ");
				if(arr[i]>arr[i+1]){
					int temp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = temp;
				}
				System.out.println(Arrays.toString(arr));
			}
		}
	}
	//÷’º´√∞≈›≈≈–Ú
	public static void finalBubbleSort(int[] arr){
		int leng = arr.length;
		boolean aaa = true;
		for(int j=0;j<leng-1;j++){
			System.out.println("µ⁄"+(j+1)+"ÃÀ");
			aaa = true;
			for(int i=0;i<leng-1-j;i++){
				System.out.print("µ⁄"+(i+1)+"¥Œ");
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
