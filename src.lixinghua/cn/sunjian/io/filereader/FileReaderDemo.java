package cn.sunjian.io.filereader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * 使用字符输入流（Reader）类读取操作：
 * 	
 * 		使用字符流读取内容
 * 
 * 			以字符数组的形式读取数据
 * 
 * @author jack
 *
 */
public class FileReaderDemo {

	public static void main(String[] args) throws IOException {

		noCycleReader();
		cycleReader();
	}

	/*
	 * 使用循环的方式读取（判断文件是否读到底的方式）
	 */
	private static void cycleReader() throws IOException {

		File  file2 = new File("c:"+File.separator+"text2.txt");//指定文件
		
		Reader fr2 = null;//定义字符输入（读取）流对象
		
		fr2 = new FileReader(file2);//使用子类实例化父类
		
		char[] c2 = new char[1024];//定义char数组，用来放置读取到的内容
		

		/*
		 * 使用read()方法，循环读取内容：一次读取一个字符的方式，
		 * 将每次读取到的内容，存储在字符数组中
		 */
		int temp = 0;//用于存放内容，并判断内容的末尾是否为-1，如果是-1，代表没有内容了，读完了
		
		int len = 0;//用于记录字符的个数，主要是为了给数组中指定的位置，顺序存放内容
		
		while((temp = fr2.read()) != -1){//判断读取到的内容是否还有
			
			c2[len] = (char)temp;//将读取到内容存储到字符数组中
			len++;//用来记录字符的个数（位置）
			
		}
		
		System.out.println("contents:\r\n"+new String(c2,0,len));
		
		fr2.close();//关闭输入流
	}

	/*
	 * 以字符数组的方式读取
	 */
	private static void noCycleReader() throws FileNotFoundException, IOException {
		File  file = new File("c:"+File.separator+"text2.txt");//指定文件
		
		Reader fr = null;//定义字符输入（读取）流对象
		
		fr = new FileReader(file);//使用子类实例化父类
		
		char[] c = new char[1024];//定义char数组，用来放置读取到的内容
		
		int len = fr.read(c);//读取内容到字符数组c中，并返回数组的长度
		
		System.out.println("contents:\r\n"+new String(c,0,len));
		
		fr.close();//关闭输入流
	}

}
