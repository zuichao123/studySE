package com.sunjian.basicmethod_practice;
/**
 * 使用查表法查看星期几
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
			return "没有此星期！！！";
		}
		String[] weeks = {"","星期一","星期二","星期三","星期四","星期五","星期六","星期日"};
		return weeks[num];
	}
}
