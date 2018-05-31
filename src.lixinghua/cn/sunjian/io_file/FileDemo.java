package cn.sunjian.io_file;

import java.io.File;
import java.io.IOException;

/**
 * java_IO练习：
 * 	
 * 		练习以下实例：
			1.创建一个新文件；
			2.删除一个指定的文件；
			3.综合创建、删除文件的操作；
			4.创建一个文件夹；
			5.列出指定目录的全部文件；
			6.判断一个给定的路径是否是目录；
 * 
 * 			File.separator：表示当前系统的路径分隔符
 * 
 * @author jack
 *
 */
public class FileDemo {

	public static void main(String[] args) {

		File file = new File("c:"+File.separator+"users\\jack\\desktop\\2.txt");//实例化File类对象
		
		createFile(file);//创建文件
		
		deleteFile(file);//删除文件
		
		createAndDelete(file);//综合创建、删除文件操作
		
	}

	
	
	private static void createAndDelete(File file) {

		if (file.exists()) {//如果文件已经存在，就删除
			file.delete();
		}else {
			try {
				file.createNewFile();//如果不存在就创建文件
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}



	private static void deleteFile(File file) {
		if (file.exists()) {//判断文件如果存在就删除			
			file.delete();
		}
	}

	private static void createFile(File file) {
		try {
			file.createNewFile();//创建文件
		} catch (IOException e) {
			e.printStackTrace();//输出异常
		}
	}

}
