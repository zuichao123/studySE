package cn.sunjian.date;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * SimpleDateFormat类，练习：
 * 
 * @author jack
 *
 */
public class DateDemo3 {

	public static void main(String[] args) {

		String strDate = "2018-04-20 08:33:30.456";
		
		//准备第一个模板，从字符串中提取日期数字；（根据提示的字符串日期格式创建此模块，用于提取提供的字符中的日期）
		String pat1 = "yyyy-MM-dd HH:mm:ss.SSS";
		
		//准备第二个模板，将提取后的日期数字变为指定的格式
		String pat2 = "yyyy年MM月dd日 HH时mm分ss秒SSS毫秒";
		
		//实例化模板
		SimpleDateFormat sdf1 = new SimpleDateFormat(pat1);
		SimpleDateFormat sdf2 = new SimpleDateFormat(pat2);
		
		//定义时间对象
		Date date = null;
		
		try {
			date = sdf1.parse(strDate);//将给定的字符串中的日期提取出来
		} catch (Exception e) {		   //如果提取的字符串格式有误，则进行异常出来
			e.printStackTrace();	   //打印异常信息
		}
		
		//将日期变为新的格式
		System.out.println(sdf2.format(date));
		
		
	}

}
