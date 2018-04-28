package cn.sunjian.io.outputstream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 
 * java.io练习：
 * 
 * 		OutputStream类练习
 * 
 * @author jack
 *
 */
public class OutputStreamDemo {

	public static void main(String[] args) throws IOException {

		//1.使用File类找到一个文件
		File file = new File("c:"+File.separator+"text.txt");
		
		//2.通过子类实例化父类对象
		OutputStream out = null;//准备一个输出对象
		out = new FileOutputStream(file);//子类实例化父类对象
		
		//3.进行读写操作(因为OutputStream类只能写入byte，so。。。)
		String str = "my name is jack!";//定义输出的内容
		byte [] b = str.getBytes();//将字符串转成byte数组
		out.write(b);//写入内容，将内容输出
		
		//4.关闭输出流
		out.close();
		
	}

}
