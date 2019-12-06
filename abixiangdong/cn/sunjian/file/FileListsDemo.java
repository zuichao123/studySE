package cn.sunjian.file;

import java.io.File;

import cn.sunjian.filter.FilterByJava;
import cn.sunjian.filter.SuffixFilter;

public class FileListsDemo {

	public static void main(String[] args) {
		
		FileListDemo();
//		FileListDemo_2();
//		FileListDemo_3();
		FileListDemo_4();
	}

	/*
	 * 根据传入的指定后缀条件获取指定的文件
	 */
	public static void FileListDemo_4() {
		
		File dir = new File("c:\\");
		
		String[] names = dir.list(new SuffixFilter(".java"));
		
		for(String name:names){
			System.out.println(name);
		}
		
	}

	/*
	 * 获取c盘中不是隐藏的文件和目录
	 */
	public static void FileListDemo_3() {

		File dir = new File("c:\\");
		
		File[] files = dir.listFiles();
		
		for(File file : files){
			System.out.println(file);
		}
	}

	/*
	 * 获取c盘下所有的.java文件
	 */
	public static void FileListDemo_2() {
		
		File dir = new File("c:\\");
		
		String [] names = dir.list(new FilterByJava());
		
		for(String name:names){
			System.out.println(name);
		}
		
	}

	/*
	 * 获取当前目录下所有的目录名称及文件名称，包含隐藏文件
	 * 调用list方法的file对象中封转的必须是目录
	 * 否则会发生空指针异常
	 * 如果访问的时系统级木也会发生空指针异常
	 * 
	 * File file = new File("c:\\abc");
	 * 如果目录存在，但是没有内容，会返回一个数组，但是长度为零
	 * 
	 * 获取所有的。java文件
	 * 
	 * 
	 */
	
	public static void FileListDemo() {
		
		File file = new File("c:\\");
		
		String [] names = file.list();
		
		for(String name:names){
			System.out.println(name);
		}
		
	}

}
