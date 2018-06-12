package cn.sunjian.io_filewrite;

import java.io.FileWriter;
import java.io.IOException;


public class FileWriteDemo {

	private static final String LINE_SEPARATOR = System.getProperty("line.separator");

	public static void main(String[] args) throws IOException {

		//创建一个可以往文件中写入字符数据的字符输出流对象。
		/**
		 * 如果文件不存在，则会自动创建
		 * 如果文件存在，则会被覆盖
		 * 
		 * 如果构造函数中加入true，可以实现对文件进行续写！
		 */
		
		FileWriter fw = new FileWriter("demo.txt",true);
	
		/*
		 * 调用Writer对象中的write（String）方法，写入数据
		 * 
		 * 其实数据写入到临时存储缓冲区中
		 */
		fw.write("孙健"+LINE_SEPARATOR+"孙健");
		
		/*
		 * 进行刷新，将数据直接写到目的地中
		 */
		fw.flush();
		
		/*
		 * 关闭流，关闭资源.在关闭前会先调用flush方法刷新缓冲区中的数据。
		 */
		fw.close();
		
	}

}
