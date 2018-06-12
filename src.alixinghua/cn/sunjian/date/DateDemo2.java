package cn.sunjian.date;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * DateFormat类练习：
 * 
 * 使用DateFormat类完成Date类的转换功能：
 * 		public final String format(Date date);
 * 
 * @author jack
 *
 */
public class DateDemo2 {

	public static void main(String[] args) {

		DateFormat df1 = null;//声明一个DateFormat
		DateFormat df2 = null;

		df1 = DateFormat.getDateInstance(DateFormat.YEAR_FIELD,new Locale("zh", "CN"));//得到日期的DateFormat对象
		df2 = DateFormat.getDateTimeInstance(DateFormat.YEAR_FIELD,DateFormat.ERA_FIELD,new Locale("zh", "CN"));//得到日期时间的DateFormat对象
		
		//采用自定义格式化操作
		System.out.println("DATE："+df1.format(new Date()));//按照日期格式化
		System.out.println("DATETIME："+df2.format(new Date()));//按照时间格式化
		
	}

}
