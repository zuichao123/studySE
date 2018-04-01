package cn.sunjian.otherapi;

import java.util.Calendar;

/**
 * 日历 celendar类练习
 * 
 * @author sunjian
 *
 */
public class CalendarDemo {

	public static void main(String[] args) {
		
		int year = 2012;
		
//		showEveryYearTwoMonthAllDayNumber(year);
		showYesterdayNowTime();
	}

	/**
	 * 显示昨天的现在的时间
	 * 获取现在的时间，往前一天
	 */
	
	private static void showYesterdayNowTime() {
		Calendar c = Calendar.getInstance();
		
		c.add(Calendar.DAY_OF_MONTH, -1);
		
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH)+1;
		int day = c.get(Calendar.DAY_OF_MONTH);
		int week = c.get(Calendar.DAY_OF_WEEK);
		int hour = c.get(Calendar.HOUR);
		int minute = c.get(Calendar.MINUTE);
		int s = c.get(Calendar.SECOND);
		
		
		System.out.println(year+"年"+month+"月"+day+"日"+getWeek(week)+hour+":"+minute+":"+s);
	
	
	}



	/**获取任何一年中的二月的天数
	 * @param c
	 */
	public static void showEveryYearTwoMonthAllDayNumber(int year) {
		
		Calendar c = Calendar.getInstance();
		//设置当前时间
		c.set(year, 2, 1);
		//日期偏移
//		c.add(Calendar.YEAR, 2);
//		c.add(Calendar.MONTH, 2);
		c.add(Calendar.DAY_OF_MONTH, -1);
		
		showNowDate(c);
	}

	/**
	 * @param c
	 */
	public static void showNowDate(Calendar c) {
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH)+1;
		int day = c.get(Calendar.DAY_OF_MONTH);
		int week = c.get(Calendar.DAY_OF_WEEK);
		
		System.out.println(year+"年"+month+"月"+day+"日"+getWeek(week));
	}

	public static String getWeek(int week) {
		String [] aa = {"","星期日","星期一","星期二","星期三","星期四","星期五","星期六"};
		
		return aa[week];
	}

	
}
