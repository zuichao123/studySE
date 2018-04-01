package com.sunjian.basicmethod.practice;

/**
 * 查表法
 * 将一个整数转换成16进制打印出来
 * @author sunjian
 *
 */
public class TestSelectTable {
	public static void main(String[] args) {
		int num = 11;
		toBinary(num);
		toHex(num);
		toOctal(num);
		System.out.println(Integer.toBinaryString(num));
	}
	
	public static void toHex(int num){
		System.out.print("数字"+num+"转为16进制后为：");
		trans(num, 15, 4);
	}
	public static void toBinary(int num){
		System.out.print("数字"+num+"转为2进制后为：");
		trans(num, 1, 1);
	}
	public static void toOctal(int num){
		System.out.print("数字"+num+"转为8进制后为：");
		trans(num, 7, 3);
	}
	
	
	
	
	public static void trans(int num,int base,int offset){
		
		if (num==0) {
			System.out.println("0");
			return;
		}
		char [] chs = {'0','1','2','3','4','5',
				       '6','7','8','9','A','B',
				       'C','D','E','F'
				      };
		
		char [] arr = new char[32];
		//定义数组的角标
		int pos = arr.length;		
		while(num!=0){
			int temp = num & base;
			//将值从数组的最后一位往前存储，便于取出
			arr[--pos] = chs[temp];
			num = num >>> offset;
		}
		for(int i=pos; i<arr.length; i++){
			System.out.print(arr[i]);
		}
		System.out.println();
	}
	
	
	
	
}
