package com.sunjian.basicmethod_practice;
/**
 * ʹ�ò���鿴���ڼ�
 * @author sunjian
 *
 */
public class TestSelectTable02 {

	public static void main(String[] args) {
		String week = getWeek(5);
		System.out.println(week);
	}
	
	public static String getWeek(int num){
		if (num>7 || num<1) {
			return "û�д����ڣ�����";
		}
		String[] weeks = {"","����һ","���ڶ�","������","������","������","������","������"};
		return weeks[num];
	}
}
