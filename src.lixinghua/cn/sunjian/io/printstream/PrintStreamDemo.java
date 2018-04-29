package cn.sunjian.io.printstream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/**
 * 打印流练习：
 * 
 * 		字节打印流:PrintStream
 * 
 * @author jack
 *
 */
public class PrintStreamDemo {

	public static void main(String[] args) throws IOException {

		PrintStream ps = null;//定义字节打印流对象
		
		//实例化对象
		ps = new PrintStream(new FileOutputStream(new File("c:"+File.separator+"text7.txt")));
	
		ps.print("today is sunday!");
		ps.println("tomorrow is monday!");
		ps.print("1+1="+2);
	
		String name = "sunjian";
		int age = 30;
		char sex = 'M';
		float score = 99.999f;
		
		ps.printf("姓名：%s,年龄：%d,性别：%c,成绩：%f",name,age,sex,score);
		
		ps.close();//关闭打印流
	}

}
