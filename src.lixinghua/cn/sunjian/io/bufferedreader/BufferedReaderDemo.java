package cn.sunjian.io.bufferedreader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BufferedReader类：操作练习
 * 
 * 		读取键盘录入的信息，
 * 		一次读取一行；
 * 		并打印出到控制台。
 * 
 * @author jack
 *
 */
public class BufferedReaderDemo {

	public static void main(String[] args) {

		BufferedReader buf = null;//声明对象
		
		buf = new BufferedReader(new InputStreamReader(System.in));
		
		String str = null;//接收输入的内容
		
		System.out.println("请输入：");
		
		try {
			str = buf.readLine();//读取一行内容
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("输入的信息："+str);//输出信息
		
	}

	/*
	 * 此时，可以输入很长的内容，每次一回车为结束。
	 */
}
