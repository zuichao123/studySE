package cn.sunjian.maptest;

import java.util.HashMap;
import java.util.Map;

public class MapTest2 {

	public static void main(String[] args) {

		/**
		 * Map在有映射关系时，可以优先考虑用
		 * 在查表法中的应用较为多见。
		 */
		
		String string = getWeek(7);
		System.out.println(string);
		System.out.println(getWeekByMap(string));
	}

	public static String getWeekByMap(String week){
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("星期一", "monday");
		map.put("星期二", "tus");
		map.put("星期三", "wes");
		map.put("星期四", "kjd");
		map.put("星期五", "fri");
		map.put("星期天", "qi");
		map.put("星期六", "liu");
		map.put("星期七", "qi");
		
		return map.get(week);
	}
	
	public static String getWeek(int week) {
		
		if (week<1 || week>7) {
			throw new RuntimeException("输入错误，请重新输入！");
		}
		String [] weeks = {"","星期一","星期二","星期三","星期四","星期五","星期六","星期天"};
		
		return weeks[week];
	}

}
