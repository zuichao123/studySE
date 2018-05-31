package cn.sunjian.io_file;

import java.io.File;

/**
 * java_IO练习：
 * 	
 * 		判断是否是目录：
 * 
 * @author jack
 *
 */
public class FileDemo4 {

	public static void main(String[] args) {

		File file = new File("c:"+File.separator+"users\\jack\\desktop\\2");//实例化File类对象
		
		if (file.exists()) {			
			if(file.isDirectory()){
				System.out.println(file.getPath()+"：是目录");
			}else {
				System.out.println(file.getPath()+"：不是目录");
			}
		}else {
			System.out.println("目标不存在！");
		}
		
		
	}

}
