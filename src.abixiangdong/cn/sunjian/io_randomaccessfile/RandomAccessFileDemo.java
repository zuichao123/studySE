package cn.sunjian.io_randomaccessfile;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileDemo {

	public static void main(String[] args) throws IOException {

		/**
		 * RandomAccessFile:随机访问文件（目的只能是文件(包括文本文件、媒体文件)）
		 * 不是io体系中的子类
		 * 
		 * 特点：
		 * 1,该对象既能读，又能写；
		 * 2,该对象内部维护了一个byte数组，并通过指针可以操作数组中的元素；
		 * 3,可以通过getFilePointer方法获取指针的位置，和通过seek方法设置指针的位置。
		 * 4,其实该对象就是将字节输入流和输出流，进行了封装。
		 * 5,该对象的源或者目的只能是文件，通过构造函数就可以看出。
		 * 
		 * 6，一般多线程写入时可用到此对象。
		 * 
		 */
		
		
//		writeFile();
		
//		readFile();
		
		randomWrite();
		
	}
	
	//使用RandomAccessFile对象随机写入内容
	public static void randomWrite() throws IOException{
		
		RandomAccessFile raf = new RandomAccessFile("ranacc.txt", "rw");
		
		//往指定位置写入数据。
		raf.seek(3*8);
		
		
		raf.write("haha".getBytes());
		raf.writeInt(102);
		
		raf.close();
		
	}
	
	
	
	//使用RandomAccessFile对象读取指定的文件中的内容
	public static void readFile() throws IOException {

		RandomAccessFile raf = new RandomAccessFile("ranacc.txt", "r");
		
		//通过seek设置指针的位置
		raf.seek(1*8);//随即的读取，只要指定指针的位置即可。
		
		byte[] buf = new byte[4];
		raf.read(buf);
		
		String name = new String(buf);
		
		int age = raf.readInt();//一次读4个字节
		
		System.out.println(name);
		System.out.println(age);
		
		System.out.println("pos:"+raf.getFilePointer());//获取指针位置
		
		raf.close();
		
	}

	//使用RandomAccessFile对象写入一些人员信息，比如姓名和年龄
	public static void writeFile() throws IOException{
		
		/*
		 * 如果文件不存在，则创建；如果文件存在，不创建
		 */
		RandomAccessFile raf = new RandomAccessFile("ranacc.txt", "rw");
		
		raf.write("张三".getBytes());
		raf.writeInt(97);
		raf.write("小强".getBytes());
		raf.writeInt(98);
		
		raf.close();
	}
	
	
}
