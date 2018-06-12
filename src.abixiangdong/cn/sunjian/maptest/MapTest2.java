package cn.sunjian.maptest;

import java.util.HashMap;
import java.util.Map;

public class MapTest2 {

	public static void main(String[] args) {

		/**
		 * Map����ӳ���ϵʱ���������ȿ�����
		 * �ڲ���е�Ӧ�ý�Ϊ�����
		 */
		
		String string = getWeek(7);
		System.out.println(string);
		System.out.println(getWeekByMap(string));
	}

	public static String getWeekByMap(String week){
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("����һ", "monday");
		map.put("���ڶ�", "tus");
		map.put("������", "wes");
		map.put("������", "kjd");
		map.put("������", "fri");
		map.put("������", "qi");
		map.put("������", "liu");
		map.put("������", "qi");
		
		return map.get(week);
	}
	
	public static String getWeek(int week) {
		
		if (week<1 || week>7) {
			throw new RuntimeException("����������������룡");
		}
		String [] weeks = {"","����һ","���ڶ�","������","������","������","������","������"};
		
		return weeks[week];
	}

}
