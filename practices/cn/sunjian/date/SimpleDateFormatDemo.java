package cn.sunjian.date;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 基于SimpleDate类的操作：
 * 		获取系统时间
 * 		获取时间戳
 * 	
 *   java.util.Date已经是一个完整的日期了，SimpleDate类中存在一个方法，
 *   可以针对于Date重新格式化，那么如果现在将一个表示当前日期的date对象SimpleDateFormat类指定好的模板进行相关的格式化操作的话，
 *   那么取得时间就非常方便了。
 * 	
 * @author sunjian
 *
 */

class DateTime2{
	
	private SimpleDateFormat sdf = null;//声明一个SimpleDateFormat对象，
	
	/*
	 * 定义方法：getDate
	 * 	 得到一个日期，格式为：
	 * 		yyyy-MM-dd HH:mm:ss.SSS
	 */
	public String getDate(){
		
		this.sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		
		return this.sdf.format(new Date());//将当前日期进行格式化操作
	}
	/*
	 * 定义方法：getDateComplete
	 * 		得到一个日期,格式为：
	 * 			yyyy年MM月dd日HH时mm分ss秒SSS毫秒
	 */
	public String getDateComplete(){
		
		this.sdf = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒SSS毫秒");
		
		return this.sdf.format(new Date());//将当前日期进行格式化操作

	}
	/*
	 * 定义方法：getTimeStamp
	 * 		得到一个时间戳
	 */
	public String getTimeStamp(){
		
		this.sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		
		return this.sdf.format(new Date());//将当前日期进行格式化操作
	}

}

public class SimpleDateFormatDemo {

	public static void main(String[] args) {
		
		DateTime2 dt2 = new DateTime2();
		
		System.out.println("系统时间："+dt2.getDate());
		System.out.println("中文系统时间："+dt2.getDateComplete());
		System.out.println("时间戳："+dt2.getTimeStamp());

	}

}
