package cn.sunjian.io.file;

import java.io.File;

/**
 * java_IO练习：
 * 	
 * 		创建目录操作
 * 
 * @author jack
 *
 */
public class FileDemo2 {

	public static void main(String[] args) {

		File file = new File("c:"+File.separator+"users\\jack\\desktop\\2");//实例化File类对象
		
		file.mkdir();//创建文件夹
		
	}

}
