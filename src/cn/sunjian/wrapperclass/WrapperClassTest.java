package cn.sunjian.wrapperclass;

import java.util.Arrays;

/**
 * ��ϰ��װ��
 * 
 * @author sunjian
 *
 */

/**
 * ��һ���ַ����е���ֵ���д�С���������
 * ��120 718 19 -7 818 361 29 4 0 11��
 * 
 * ˼·��
 * 1.��λ�ȡ������ַ����е���Щ��Ҫ�������ֵ��
 * 		������Щ��ֵ����ʹ�ÿո����ָ��ģ�
 * 		���о����ַ���������и�����󴮱�ɶ��С����
 * 2.��ֵ���С�ַ�������α��һ��int���أ�
 * 		�ַ���-->�����������ͣ�ʹ�ð�װ�ࡣ
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
		
		//1.���ַ�������ַ�������
		String[] str_arr = stringToArray(numStr); 
		
		//2.���ַ���������int����
		int[] int_arr = toIntArray(str_arr);
		
		//3.��int��������
		mySortArray(int_arr);
		
		//4.��������int���������ַ���
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
		
		//����һ�����ַ���������ͬ��С��int������
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
