package cn.sunjian.charstream;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriteDemo {

	public static void main(String[] args) throws IOException {

		FileWriter fw = new FileWriter("buf.txt");
	
		//为了提高写入的效率，使用了字符流的缓冲区。
		//创建了一个字符写入流的缓冲区对象，并和指定要被缓冲的流对象相关联。
		BufferedWriter bufw = new BufferedWriter(fw);
		
		//使用缓冲区的写入方法将数据先写入到缓冲区中。
		for (int i = 0; i < 5; i++) {			
			bufw.write("abcdefghijklmn");
			bufw.newLine();
		}
		
		//使用缓冲区的刷新方法将数据刷新到目的地中。
		bufw.flush();
		
		//关闭缓冲区
		bufw.close();
		
	}

}
