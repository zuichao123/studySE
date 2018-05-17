package cn.sunjian.io.scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import cn.sunjian.utils.CurrentPath;

/**
 * java.io练习：
 * 		
 * 		使用Scanner类输入数据：
 * 			1.实现基本的数据输入
 *			2.实现日期格式的数据输入
 * 			3.从文件中得到(读取)数据
 * 
 * @author sunjian
 */
public class ScannerDemo {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);//接收键盘数据
		String str = null;//存放键盘数据
		
		dataInput(scan,str);//1.实现基本的数据输入
		dateInput(scan,str);//2.实现日期格式的数据输入
		readFile();//3.从文件中得到(读取)数据
	}

	/*
	 * 使用Scanner类读取文件内容
	 * 如果文件中，有空格、换行等时：使用StringBuffer来接收。
	 */
	private static void readFile() {
		File f = new File(CurrentPath.deskTop()+"1.txt");
		Scanner scan = null;
		try {
			scan = new Scanner(f);//读取指定文件数据
		} catch (FileNotFoundException e) {	
			e.printStackTrace();
		}
		
		StringBuffer sbf = new StringBuffer();//使用StringBuffer接收读取的数据
		
		while (scan.hasNext()) {
			sbf.append(scan.nextLine()).append('\n');//读取一行数据，换行
		}
		System.out.println("文件内容："+sbf);		
	}

	/*
	 * Scanner类虽然可以接收各种类型，但是对于日期型的数据却无法接收；
	 * 如果想要接收Date类型的数据，则只能通过字符串转型，但是在接收的时候依然可以使用
	 * Scanner类中提供的方法进行验证。
	 */
	private static void dateInput(Scanner scan,String str) {

		Date date = null;//日期对象
		
		System.out.println("请输入日期：（格式：yyyy-MM-dd）");
		
		if (scan.hasNext("^\\d{4}-\\d{2}-\\d{2}$")) {//如果输入的是日期
			str = scan.next("^\\d{4}-\\d{2}-\\d{2}$");//接收日期
			try {
				date = new SimpleDateFormat("yyyy-MM-dd").parse(str);//将接收的日期格式的字符串转换成日期类型
			} catch (ParseException e) {
				e.printStackTrace();
			}
			System.out.println("输入的日期："+date);
		}else {
			System.out.println("输入的日期格式不正确！");
		}		
	}

	/*
	 * 比直接使用BufferedReader更加方便。
	 * 如果输入数据之间有空格，则会以空格为分隔符。
	 * 将分隔符变为回车。
	 */
	private static void dataInput(Scanner scan,String str) {
		int i = 0;//存放整型数据
		float f = 0.0f;//存放浮点型数据
		
		System.out.println("请输入：");
				
		if (scan.hasNextInt()) {//如果输入的是整数
			i = scan.nextInt();//接收整型数据
			System.out.println("输入的是整数："+i);
		}else if (scan.hasNextFloat()) {//如果输入的是小数
			f = scan.nextFloat();//接收浮点型数据
			System.out.println("输入的是小数："+f);
		}else{
			scan.useDelimiter("\n");//设置分隔符为回车
			str = scan.next();//接收数据			
			System.out.println("输入的是字符串："+str);
		}
	}	
}
