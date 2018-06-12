package cn.sunjian.io_outputstream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 
 * java.io练习：
 * 
 * 		OutputStream类练习：字节输出流（写）
 * 
 * 			在文件的末尾追加内容；
 * 			并且追加内容时，换行；\r\n
 * 			采用循环方式写入：
 * 
 * @author jack
 *
 */
public class OutputStreamDemo2 {

	public static void main(String[] args) throws IOException {

		//1.使用File类找到一个文件
		File file = new File("c:"+File.separator+"text2.txt");
		
		//2.通过子类实例化父类对象
		OutputStream out = null;//准备一个输出对象
		
		out = new FileOutputStream(file,true);//子类实例化父类对象[表示在文件的末尾追加内容]
		
		//3.进行读写操作(因为OutputStream类只能写入byte，so。。。)
		String str = "\r\nmy name is jack!";//定义输出的内容
		byte [] b = str.getBytes();//将字符串转成byte数组
		
		for(int i=0;i<b.length;i++){
			out.write(b[i]);//每次只写入一个
		}
		
		/*
		 * 以上的操作中，在写入数据之后，文件之前的内容已经不存在了，
		 * 因为在IO操作中默认的情况是将其进行覆盖的，那么如果现在要想执行追加的功能，
		 * 则必须设置追加的操作，找到FileOutputStream类。
		 */
		
		//4.关闭输出流
		out.close();
		
	}

}
