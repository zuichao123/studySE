package com.sunjian.basicmethod.practice;

/**
 * ���
 * ��һ������ת����16���ƴ�ӡ����
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
		System.out.print("����"+num+"תΪ16���ƺ�Ϊ��");
		trans(num, 15, 4);
	}
	public static void toBinary(int num){
		System.out.print("����"+num+"תΪ2���ƺ�Ϊ��");
		trans(num, 1, 1);
	}
	public static void toOctal(int num){
		System.out.print("����"+num+"תΪ8���ƺ�Ϊ��");
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
		//��������ĽǱ�
		int pos = arr.length;		
		while(num!=0){
			int temp = num & base;
			//��ֵ����������һλ��ǰ�洢������ȡ��
			arr[--pos] = chs[temp];
			num = num >>> offset;
		}
		for(int i=pos; i<arr.length; i++){
			System.out.print(arr[i]);
		}
		System.out.println();
	}
	
	
	
	
}
