package cn.sunjian.io_print;

import java.io.IOException;
import java.io.PrintStream;

public class PrintStreamDemo {

	public static void main(String[] args) throws IOException {

		/**
		 * PrintStream（字节打印流）
		 * 1,提供了打印方法可以对多种数据类型值进行打印，并保持数据的表示形式。
		 * 2，它不抛IOExcetion
		 * 
		 * 构造函数：
		 * 1，字符串路径
		 * 2.File对象
		 * 3，字节输出流
		 * 
		 */
		
		PrintStream out = new PrintStream("print.txt");
		
		out.write(97);//只写内容的最低8位。（最低的这个字节）
		
//		out.print(97);//打的是啥，目的地就是啥（其实就是将打印的内容先变成字符串然后在打印到目的地）
		
		out.close();
	}

}
