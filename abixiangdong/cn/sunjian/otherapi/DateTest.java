package cn.sunjian.otherapi;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Date类练习
 * 
 * 2018-3-17与2018-4-18之间相差多少天？
 * 
 * @author sunjian
 *
 */
public class DateTest {

	public static void main(String[] args) throws ParseException {
		String str_date1 = "2018-3-17";
		String str_date2 = "2018-4-18";
		
		test(str_date1, str_date2);
	}

	public static void test(String str_date1, String str_date2) throws ParseException {
	
		//1.将日期字符串转成日期对象;定义日期格式对象
		DateFormat dateFormat = DateFormat.getDateInstance();
		dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		Date date1 = dateFormat.parse(str_date1);
		Date date2 = dateFormat.parse(str_date2);
		
		Long time1 = date1.getTime();
		Long time2 = date2.getTime();
		
		Long time = Math.abs(time1 - time2);
		
		int day = getDay(time);
		
		System.out.println(day);
	}

	public static int getDay(Long time) {
		
		int day = (int)(time/1000/60/60/24);
		
		return day;
	}

}
