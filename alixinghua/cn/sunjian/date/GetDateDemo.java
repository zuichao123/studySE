package cn.sunjian.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * DateFormat类练习：
 * 
 * 使用DateFormat类完成Date类的转换功能：
 * 		public final String format(Date date);
 *			获取日期格式对象(自定义格式对象)
 * 
 * @author jack
 *
 */

public class GetDateDemo{
	public static void main(String[] args)throws ParseException{
	
		Date date = new Date();

		System.out.print("格式化之前的日期："+date+"\n");
		
		//获取日期格式对象(自定义日期格式)
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		
		//打印日期
		System.out.println("格式化之后的日期："+dateFormat.format(date));
	
	}
}