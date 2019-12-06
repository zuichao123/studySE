package cn.sunjian.date;

import java.text.DateFormat;
import java.util.Date;

/**
 * DateFormat类练习：
 * 
 * 使用DateFormat类完成Date类的转换功能：
 * 		public final String format(Date date);
 * 
 * @author jack
 *
 */
public class DateDemo {

	public static void main(String[] args) {

		DateFormat df1 = null;//声明一个DateFormat
		DateFormat df2 = null;

		df1 = DateFormat.getDateInstance();//得到日期的DateFormat对象
		df2 = DateFormat.getDateTimeInstance();//得到日期时间的DateFormat对象
		
		//采用默认格式化操作
		System.out.println("DATE："+df1.format(new Date()));//按照日期格式化
		System.out.println("DATETIME："+df2.format(new Date()));//按照时间格式化
		
		
	}

}
