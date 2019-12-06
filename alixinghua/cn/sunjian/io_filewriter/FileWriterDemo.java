package cn.sunjian.io_filewriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * 字符输出流操作练习：
 * 
 * 		FileWriter：
 * 
 * @author jack
 *
 */
public class FileWriterDemo {

	public static void main(String[] args) throws IOException {

		File file = new File("c:"+File.separator+"text.txt");//定义File类对象，指定文件的位置
		
		Writer writer = null;//定义字节输出流的对象
		
		writer = new FileWriter(file,true);//子类实例化父类对象;允许追加
		
		String str = "I love you xiaoyanjing\r\n";//定义写入的内容
		writer.write(str);//写入内容

		writer.close();//关闭字符输出流
	}

}
