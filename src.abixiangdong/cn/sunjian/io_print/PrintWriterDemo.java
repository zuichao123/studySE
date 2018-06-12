package cn.sunjian.io_print;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class PrintWriterDemo {

	public static void main(String[] args) throws IOException {

		/**
		 * PrintWriter:字符打印流(保证数据的原样时用)
		 * 
		 * 构造函数参数：
		 * 1，字符串路径
		 * 2，File对象、
		 * 3，字节输出流
		 * 4，字符输出流
		 * 
		 * 另外：使用newLine()方法，必须BufferedWriter
		 */
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));//定义字符读取流，读取键盘
		
//		PrintWriter out = new PrintWriter(System.out,true);//定义字符打印流，打印控制台
		PrintWriter out = new PrintWriter(new FileWriter("out.txt"),true);//给字符打印流传入一个字符输出流FileWriter并创建out.txt文件
		
		String line = null;
		
		while((line = bufr.readLine())!=null){//如果读取到的内容不为空
			if("over".equals(line))  //如果读取到的内容为over
				break;              //结束循环
			out.println(line);//换行打印读取到的内容
//			out.flush();    //刷新(如果在打印字符流中传入true，可以不用flush)
		}
		
		out.close();//关闭字符打印流
		bufr.close();//关闭字符读取流
	}

}
