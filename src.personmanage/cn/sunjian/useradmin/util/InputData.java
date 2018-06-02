package cn.sunjian.useradmin.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 定义一个输入数据类：
 * 
 * 		判断输入的数据是什么类型，从而根据指定的要求进行操作。		
 * 
 * @author sunjian
 *
 */
public class InputData {
	
	BufferedReader buf = null;//接收键盘输入数据信息对象
	
	public InputData(){//构造方法，实例化BufferedReader对象
		this.buf = new BufferedReader(new InputStreamReader(System.in));
	}

	//获取字符串信息
	public String getString(String info){
		String temp = null;//接收读取的信息
		System.out.print(info);
		try {
			temp = this.buf.readLine();//读取键盘录入的信息，一次读取一行
		} catch (IOException e) {
			e.printStackTrace();
		}
		return temp;
	}
	
	//获取整形数据
	public int getInt(String info,String err){
		int temp = 0;//用于存放整形数据
		String str = null;//接收读取的数据
		boolean flag = true;//定义一个标记
		
		while(flag){			
			str = this.getString(info);//接收数据
			if (str.matches("^\\d+$")) {//正则表达式判断，输入的数据是否为数字
				temp = Integer.parseInt(str);//将接收的字符串数字转换成整形数字
				flag = false;//结束循环
			}else {
				System.out.println(err);//否则，打印错误信息
			}
		}
		return temp;
	}
	
	//获取浮点型数据
	public float getFloat(String info,String err){
		float temp = 0;//用于存放小数数据
		String str = null;//接收读取的数据
		boolean flag = true;//定义一个标记位
		
		while(flag){
			str = this.getString(info);//接收数据^\\d+.?\\d+$
			if (str.matches("^\\d+.?\\d+$")) {//正则表达式判断，输入的数据是否为小数
				temp = Float.parseFloat(str);//将接受的数据转成小数
				flag = false;//结束循环
			}else {
				System.out.println(err);//打印错误信息
			}
		}
		return temp;
	}
	
	//获取日期格式的数据
	public Date getDate(String info,String err){
		Date temp = null;//用于存放日期数据
		String str = null;//接收读取的数据
		boolean flag = true;//定义一个标记位
		
		while(flag){
			str = this.getString(info);//接收数据
			if (str.matches("^\\d{4}-\\d{2}-\\d{2}$")) {//正则表达式判断，输入的数据是否为日期
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//定义输入的日期格式
				try {
					temp = sdf.parse(str);//将接收的字符串数据转换成日期
				} catch (ParseException e) {			
					e.printStackTrace();
				}
				flag = false;//结束循环
			}else {
				System.out.println(err);//打印错误信息
			}
		}
		return temp;
	}
	
}
