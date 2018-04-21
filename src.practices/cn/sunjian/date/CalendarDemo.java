package cn.sunjian.date;

/**
 * 基于Calendar类的操作：
 * 		获取当前日期时间
 * 		获取时间戳
 */
import java.util.Calendar;
import java.util.GregorianCalendar;

/*
 * 以后直接通过此类就可以取得日期时间
 */
class DateTime{
	
	private Calendar calendar = null;//声明一个calendar对象，
	
	public DateTime(){//构造方法中，直接实例化对象
		this.calendar = new GregorianCalendar();
	}
	
	/*
	 * 定义方法：getDate
	 * 	 得到一个日期，格式为：
	 * 		yyyy-MM-dd HH:mm:ss.SSS
	 */
	public String getDate(){
		
		//考虑到程序要频繁修改字符串，所以使用StringBuffer提升性能
		StringBuffer buf = new StringBuffer();
		
		buf.append(calendar.get(Calendar.YEAR)).append("-");//增加年
		buf.append(this.addZero(calendar.get(Calendar.MONTH)+1, 2)).append("-");//增加月
		buf.append(this.addZero(calendar.get(Calendar.DAY_OF_MONTH), 2)).append(" ");//增加日
		buf.append(this.addZero(calendar.get(Calendar.HOUR_OF_DAY), 2)).append(":");//增加时
		buf.append(this.addZero(calendar.get(Calendar.MINUTE), 2)).append(":");//增加分
		buf.append(this.addZero(calendar.get(Calendar.SECOND), 2)).append(".");//增加秒
		buf.append(this.addZero(calendar.get(Calendar.MILLISECOND), 3));//增加毫秒
		
		return buf.toString();
	}
	/*
	 * 定义方法：getDateComplete
	 * 		得到一个日期,格式为：
	 * 			yyyy年MM月dd日HH时mm分ss秒SSS毫秒
	 */
	public String getDateComplete(){
		
		//考虑到程序要频繁修改字符串，所以使用StringBuffer提升性能
		StringBuffer buf = new StringBuffer();
		
		buf.append(calendar.get(Calendar.YEAR)).append("年");//增加年
		buf.append(this.addZero(calendar.get(Calendar.MONTH)+1, 2)).append("月");//增加月
		buf.append(this.addZero(calendar.get(Calendar.DAY_OF_MONTH), 2)).append("日");//增加日
		buf.append(this.addZero(calendar.get(Calendar.HOUR_OF_DAY), 2)).append("时");//增加时
		buf.append(this.addZero(calendar.get(Calendar.MINUTE), 2)).append("分");//增加分
		buf.append(this.addZero(calendar.get(Calendar.SECOND), 2)).append("秒");//增加秒
		buf.append(this.addZero(calendar.get(Calendar.MILLISECOND), 3)).append("毫秒");//增加毫秒
		
		return buf.toString();
	}
	/*
	 * 定义方法：getTimeStamp
	 * 		得到一个时间戳
	 */
	public String getTimeStamp(){
		
		//考虑到程序要频繁修改字符串，所以使用StringBuffer提升性能
		StringBuffer buf = new StringBuffer();
		
		buf.append(calendar.get(Calendar.YEAR));
		buf.append(this.addZero(calendar.get(Calendar.MONTH)+1, 2));
		buf.append(this.addZero(calendar.get(Calendar.DAY_OF_MONTH), 2));
		buf.append(this.addZero(calendar.get(Calendar.HOUR_OF_DAY), 2));
		buf.append(this.addZero(calendar.get(Calendar.MINUTE), 2));
		buf.append(this.addZero(calendar.get(Calendar.SECOND), 2));
		buf.append(this.addZero(calendar.get(Calendar.MILLISECOND), 3));
		
		return buf.toString();
	}
	
	
	/*
	 * 定义方法：addZero
	 * 		考虑到日期中存在前导0，所以在此处加上补零的方法
	 */
	private String addZero(int num,int len){
		StringBuffer sb = new StringBuffer();
		
		sb.append(num);
		while(sb.length()<len){
			sb.insert(0,"0");//如果传入的日期的长度小于指定的长度，则在第一位置上补0
		}
		return sb.toString();
	}
}


public class CalendarDemo {
	
	public static void main(String[] args) {
		DateTime dt = new DateTime();
		
		System.out.println("系统时间："+dt.getDate());
		System.out.println("中文系统时间："+dt.getDateComplete());
		System.out.println("时间戳："+dt.getTimeStamp());
	}
	
	/*
	 * 以上程序已经取得了日期时间、中文的日期时间、时间戳，但是所有的操作都比较麻烦；
	 * 因为每一个地方还需要进行补零操作，所有，在直接使用Calendar类的时候虽然可以方便的将时间取得精确到毫秒，
	 * 但是在对应取得完整日期的时候却不这么好使了。
	 */
}
