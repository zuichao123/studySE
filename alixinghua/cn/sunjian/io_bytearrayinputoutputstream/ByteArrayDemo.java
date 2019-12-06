package cn.sunjian.io_bytearrayinputoutputstream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * 内存操作流：ByteArrayInputStream和ByteArrayOutputStream
 * 
 * 		练习：将一个大写字符串变成小写字符串，来练习内存操作流
 * 
 * @author jack
 *
 */
public class ByteArrayDemo {

	public static void main(String[] args) {

		String str = "ABCDEFGHIJKLMN";
		
		System.out.println("内容："+str);
		
		ByteArrayInputStream bis = null;//内存输入流
		ByteArrayOutputStream bos = null;//内存输出流
		
		bis = new ByteArrayInputStream(str.getBytes());//实例化内存输入流对象
		bos = new ByteArrayOutputStream();//实例化内存输出流对象
		
		int temp = 0;//存放读取到的内容
		
		while((temp = bis.read())!=-1){
			char c = (char)temp;//将读取到的内容转换为字符
			bos.write(Character.toLowerCase(c));//将读取到内容，转换成小写后，输出到内存中
		}
		
		String newStr = bos.toString();//取出内容		
		
		try {
			bis.close();
			bos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("转换后的内容："+newStr);
	}

	/*
	 * 实际上，通过实例化其子类的不同，完成的功能也不同，
	 * 如果是文件，则使用Filexxx；
	 * 如果是内存，则使用ByteArrayxxx.
	 */
}
