package com.sunjian.basicmethod_practice;

import java.util.Arrays;

/**
 * pricate Bubble Sort
 * 
 * 		ð������
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
	
	//�Ż�ð������
	public static void youHuaBubbleSort(int[] arr){
		for(int j=0;j<arr.length-1;j++){
			System.out.println("��"+(j+1)+"��");
			for(int i=0; i<arr.length-1;i++){
				System.out.print("��"+(i+1)+"��");
				if(arr[i]>arr[i+1]){
					int temp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = temp;
				}
				System.out.println(Arrays.toString(arr));
			}
		}
	}
	//�ռ�ð������
	public static void finalBubbleSort(int[] arr){
		int leng = arr.length;
		boolean aaa = true;
		for(int j=0;j<leng-1;j++){
			System.out.println("��"+(j+1)+"��");
			aaa = true;
			for(int i=0;i<leng-1-j;i++){
				System.out.print("��"+(i+1)+"��");
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
