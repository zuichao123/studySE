package cn.sunjian.io.file;

import java.io.File;

/**
 * java_IO练习：
 * 	
 * 		使用list()列出全部内容：
 * 		and
 * 		使用listFiles()列出全部内容；
 * 
 * @author jack
 *
 */
public class FileDemo3 {

	public static void main(String[] args) {

		File file = new File("c:"+File.separator);//实例化File类对象
		
		listFiles(file);
		
		System.out.println("******************************");
		
		list(file);
		
	}

	private static void list(File file) {

		String files[] = file.list();//列出给定目录中的内容
		for(int i=0;i<files.length;i++){
			System.out.println(files[i]);
		}
	}

	private static void listFiles(File file) {

		File files[] = file.listFiles();//列出全部内容
		for(int i=0;i<files.length;i++){
			System.out.println(files[i]);
		}
	}
}
