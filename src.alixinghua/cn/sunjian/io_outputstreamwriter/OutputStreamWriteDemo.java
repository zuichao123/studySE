package cn.sunjian.io_outputstreamwriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

/**
 * OutputStreamWrite类练习：写（字节流以字符流的形式：写）
 * 
 * 		将字节输出流以字符输出流的形式输出（写）。
 * 
 * @author jack
 *
 */
public class OutputStreamWriteDemo {

	public static void main(String[] args) throws IOException {

		File file = new File("c:"+File.separator+"text3.txt");//定义文件
		
		Writer writer = null;//定义字符输出流对象
		
		//将字节流变为字符流
		writer = new OutputStreamWriter(new FileOutputStream(file));//子类实例化父类对象；OutputStreamWriter子类接收的是一个字节流对象
	
		String str = "my name is jack!";//定义写入的内容
		
		writer.write(str);//写操作
		
		writer.close();//关闭输出流
		
	}

}
