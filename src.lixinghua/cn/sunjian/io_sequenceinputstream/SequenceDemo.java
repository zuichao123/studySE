package cn.sunjian.io_sequenceinputstream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.SequenceInputStream;

/**
 * java.io合并流：练习
 * 
 * 		将两个文件中的内容合并在一个文件中
 * 
 * @author sunjian
 *
 */
public class SequenceDemo {

	public static void main(String[] args) throws IOException {

		InputStream input1 = null;//定义输入流1
		InputStream input2 = null;//定义输入流2
		OutputStream ops = null;//定义输出流
		SequenceInputStream sis = null;//定义合并流
		
		input1 = new FileInputStream(new File("c:"+File.separator+"a.txt"));
		input2 = new FileInputStream(new File("c:"+File.separator+"b.txt"));
		ops = new FileOutputStream(new File("c:"+File.separator+"ab.txt"));
		sis = new SequenceInputStream(input1, input2);
		
		int temp = 0;//存放读取到内容（还可以判断是否读到了结尾-1）
		
		while((temp = sis.read()) != -1){//循环输出
			ops.write(temp);//写入内容
		}
		
		input1.close();
		input2.close();
		ops.close();
		sis.close();
	}

}
