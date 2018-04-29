package cn.sunjian.io.system;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * System类对于IO的支持
 * 
 * 		System.out
 * 		System.err
 * 		System.in
 * 
 * 		1.将当前时间打印到屏幕上
 * 		2.打印错误信息
 * 		3.键盘录入信息，并打印
 * 
 * @author jack
 *
 */
public class SystemDemo {

	public static void main(String[] args) {

//		systemOut();//输出信息到显示器
//		systemErr();//打印错误信息
//		systemIn();//键盘录入信息
		systemIn2();//键盘录入信息的另一种实现方式
	}

	private static void systemIn2() {

		InputStream in = null;//定义字节流对象
		in = System.in;//实例化
		StringBuffer sb = new StringBuffer();//定义StringBuffer对象，保存输入的内容
		
		System.out.println("请输入：");
		int temp = 0;//记录读取到的内容
		try {
			while((temp = in.read()) != -1){//判断标志位，是否还有内容
				char c = (char)temp;
				sb.append(c);//保存内容
				if (c == '\n') {//如果回车，程序退出
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("输入的信息："+sb);
		
		try {
			in.close();//关闭字节输入流
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void systemIn() {

		InputStream in = null;//定义字节输入流对象
		
		in = System.in;//实例化，键盘录入
		
		byte[] b = new byte[1024];//开辟字节数组，用于存放录入的内容
		System.out.println("请输入：");
		
		int len = 0;//记录数组的长度
		try {
			len = in.read(b);//将录入的内容，读入到byte数组中，并返回数组的长度
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("输入的信息："+new String(b,0,len));
		
		try {
			in.close();//关闭输入流
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void systemErr() {

		String string = "hello";

		try {
			System.out.println(Integer.parseInt(string));
		} catch (Exception e) {
			System.err.println(e);
		}
	}

	private static void systemOut() {
		OutputStream out = null;//定义字节输出流对象
		
		out = System.out;//实例化（此时的输出流是向屏幕上输出）
		
		Date date = new Date();
		String pattern = "yyyy-MM-dd HH:mm:ss.SSS";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		String now = sdf.format(date);

		try {
			out.write(("现在是北京时间："+now).getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			out.close();//关闭输出流
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
