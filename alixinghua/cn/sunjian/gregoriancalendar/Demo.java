package cn.sunjian.gregoriancalendar;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

public class Demo {

	public static void main(String[] args) {
		
		// get the supported ids for GMT-08:00 (Pacific Standard Time)获得GMT-08:00(太平洋标准时间)的支持id
		 String[] ids = TimeZone.getAvailableIDs(-8 * 60 * 60 * 1000);
		 // if no ids were returned, something is wrong. get out.如果没有返回id，就会出错。出去。
		 if (ids.length == 0)
		     System.exit(0);

		  // begin output开始输出
		 System.out.println("Current Time");

		 // create a Pacific Standard Time time zone创建一个太平洋标准时区
		 SimpleTimeZone pdt = new SimpleTimeZone(-8 * 60 * 60 * 1000, ids[0]);

		 // set up rules for daylight savings time制定夏令时规则。
		 pdt.setStartRule(Calendar.APRIL, 1, Calendar.SUNDAY, 2 * 60 * 60 * 1000);
//		 pdt.setEndRule(Calendar.0ctober, -1, Calendar.SUNDAY, 2 * 60 * 60 * 1000);

		 // create a GregorianCalendar with the Pacific Daylight time zone创建一个与太平洋日光时区的GregorianCalendar。
		 // and the current date and time以及当前的日期和时间。
		 Calendar calendar = new GregorianCalendar(pdt);
		 Date trialTime = new Date();
		 calendar.setTime(trialTime);

		 // print out a bunch of interesting things打印出一堆有趣的东西。
		 
		 System.out.println("ERA: " + calendar.get(Calendar.ERA));
		 System.out.println("YEAR: " + calendar.get(Calendar.YEAR));
		 System.out.println("MONTH: " + calendar.get(Calendar.MONTH));
		 System.out.println("WEEK_OF_YEAR: " + calendar.get(Calendar.WEEK_OF_YEAR));
		 System.out.println("WEEK_OF_MONTH: " + calendar.get(Calendar.WEEK_OF_MONTH));
		 System.out.println("DATE: " + calendar.get(Calendar.DATE));
		 System.out.println("DAY_OF_MONTH: " + calendar.get(Calendar.DAY_OF_MONTH));
		 System.out.println("DAY_OF_YEAR: " + calendar.get(Calendar.DAY_OF_YEAR));
		 System.out.println("DAY_OF_WEEK: " + calendar.get(Calendar.DAY_OF_WEEK));
		 System.out.println("DAY_OF_WEEK_IN_MONTH: "
		                    + calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH));
		 System.out.println("AM_PM: " + calendar.get(Calendar.AM_PM));
		 System.out.println("HOUR: " + calendar.get(Calendar.HOUR));
		 System.out.println("HOUR_OF_DAY: " + calendar.get(Calendar.HOUR_OF_DAY));
		 System.out.println("MINUTE: " + calendar.get(Calendar.MINUTE));
		 System.out.println("SECOND: " + calendar.get(Calendar.SECOND));
		 System.out.println("MILLISECOND: " + calendar.get(Calendar.MILLISECOND));
		 System.out.println("ZONE_OFFSET: "
		                    + (calendar.get(Calendar.ZONE_OFFSET)/(60*60*1000)));
		 System.out.println("DST_OFFSET: "
		                    + (calendar.get(Calendar.DST_OFFSET)/(60*60*1000)));

		 System.out.println("Current Time, with hour reset to 3");
		 calendar.clear(Calendar.HOUR_OF_DAY); // so doesn't override
		 calendar.set(Calendar.HOUR, 3);
		 System.out.println("ERA: " + calendar.get(Calendar.ERA));
		 System.out.println("YEAR: " + calendar.get(Calendar.YEAR));
		 System.out.println("MONTH: " + calendar.get(Calendar.MONTH));
		 System.out.println("WEEK_OF_YEAR: " + calendar.get(Calendar.WEEK_OF_YEAR));
		 System.out.println("WEEK_OF_MONTH: " + calendar.get(Calendar.WEEK_OF_MONTH));
		 System.out.println("DATE: " + calendar.get(Calendar.DATE));
		 System.out.println("DAY_OF_MONTH: " + calendar.get(Calendar.DAY_OF_MONTH));
		 System.out.println("DAY_OF_YEAR: " + calendar.get(Calendar.DAY_OF_YEAR));
		 System.out.println("DAY_OF_WEEK: " + calendar.get(Calendar.DAY_OF_WEEK));
		 System.out.println("DAY_OF_WEEK_IN_MONTH: "
		                    + calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH));
		 System.out.println("AM_PM: " + calendar.get(Calendar.AM_PM));
		 System.out.println("HOUR: " + calendar.get(Calendar.HOUR));
		 System.out.println("HOUR_OF_DAY: " + calendar.get(Calendar.HOUR_OF_DAY));
		 System.out.println("MINUTE: " + calendar.get(Calendar.MINUTE));
		 System.out.println("SECOND: " + calendar.get(Calendar.SECOND));
		 System.out.println("MILLISECOND: " + calendar.get(Calendar.MILLISECOND));
		 System.out.println("ZONE_OFFSET: "
		        + (calendar.get(Calendar.ZONE_OFFSET)/(60*60*1000))); // in hours
		 System.out.println("DST_OFFSET: "
		        + (calendar.get(Calendar.DST_OFFSET)/(60*60*1000))); // in hours
		 
	}
}
