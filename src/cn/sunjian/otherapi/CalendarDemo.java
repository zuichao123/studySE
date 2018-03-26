package cn.sunjian.otherapi;

import java.util.Calendar;

/**
 * ���� celendar����ϰ
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
	 * ��ʾ��������ڵ�ʱ��
	 * ��ȡ���ڵ�ʱ�䣬��ǰһ��
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
		
		
		System.out.println(year+"��"+month+"��"+day+"��"+getWeek(week)+hour+":"+minute+":"+s);
	
	
	}



	/**��ȡ�κ�һ���еĶ��µ�����
	 * @param c
	 */
	public static void showEveryYearTwoMonthAllDayNumber(int year) {
		
		Calendar c = Calendar.getInstance();
		//���õ�ǰʱ��
		c.set(year, 2, 1);
		//����ƫ��
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
		
		System.out.println(year+"��"+month+"��"+day+"��"+getWeek(week));
	}

	public static String getWeek(int week) {
		String [] aa = {"","������","����һ","���ڶ�","������","������","������","������"};
		
		return aa[week];
	}

	
}
