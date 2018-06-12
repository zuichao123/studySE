package cn.sunjian.otherapi;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * date 类 日期类
 * 
 * @author sunjian
 *
 */
public class DateDemo {

	public static void main(String[] args) throws ParseException {
		
//		methodDemo_1();
		
//		methodDemo_2();
		
		methodDemo_3();
		
	}
	
	
	/*
	 *将日期格式的字符串转换成日期对象
	 * 
	 * 使用的是DateFormat中的parse()方法。
	 */
	public static void methodDemo_3() throws ParseException {
		
		String str_date = "2018年01月04日";
		str_date = "2018---02---05";
		
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG);
		
		dateFormat = new SimpleDateFormat("yyyy---MM---dd");
		
		Date date = dateFormat.parse(str_date);
		
		System.out.println(date);
	}

	/*
	 * 对日期对象进行格式化
	 * 将日期对象转换成日期格式的字符串
	 * 使用的是DateFormat中的format方法。
	 */
	public static void methodDemo_2() {
		
		Date date = new Date();
		
		//获取日期格式对象，具体是默认的风格。FULL LONG可以指定风格。
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG);
		dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG);
		
		
		//如果风格是自定定义的，如果解决呢？
		dateFormat = new SimpleDateFormat("yyyy--MM--dd");
		
		String str_date = dateFormat.format(date);
		
		System.out.println(str_date);
	
	}

	/**
	 * 将当前日期和时间封装成date对象
	 */
	public static void methodDemo_1() {
		@SuppressWarnings("unused")
		long time = System.currentTimeMillis();
//		System.out.println(time);
		
		Date date = new Date();//将当前日期和时间封装成date对象
		System.out.println(date);
		
//		Date date2 = new Date(15148162706900);//将指定毫秒值封装成date对象
//		System.out.println(date2);
	}

	/**
	 * 日期对象和毫秒值之间的转换
	 * 
	 * 毫秒值-->日期对象
	 * 	1.通过Date对象的构造方法new Date(timeMillis);
	 *  2.还可以通过setTime设置
	 *  因为可以通过Date对象的方法对该日期中的各个字段（年月日等）进行操作。
	 *  
	 *  日期对象-->毫秒值：
	 *   1.getTime方法
	 *   因为可以通过具体的数值进行运算。
	 *  
	 *  
	 */
	
	
}
