package cn.sunjian.file.demo;

import java.io.File;

public class FileDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		construorDemo();
	}

	public static void construorDemo() {
		
		//可以将一个已存在的，或者不存在的文件或者目录封装成对象。
		File file = new File("a.txt");
		
		File file2 = new File("c:\\","a.txt");
		
		File f  = new File("C:\\");
		File file3 = new File(f,"a.txt");
		//分隔符的应用
		File file4 = new File("c:"+System.getProperty("file.separator")+"abc\\a.txt");
		File file5 = new File("c:"+File.separator+"abc"+File.separator+"a.txt");
		
				
		
		
	}
	
	

}
