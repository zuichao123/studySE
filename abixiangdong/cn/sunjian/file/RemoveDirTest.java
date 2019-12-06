package cn.sunjian.file;

/**
 * 删除指定的整个目录
 * 	删除时，先遍历此目录中的文件，如果有文件先删除文件后，在删除目录
 */

import java.io.File;

public class RemoveDirTest {

	public static void main(String[] args) {

		/**
		 * 删除一个带内容的目录
		 * 原理：必须从里边往外删
		 * 需要进行深度遍历
		 */
		
		File dir = new File("f:\\新建文件夹 - 副本");//指定目录
		
		removeDir(dir);
		
	}

	public static void removeDir(File dir) {

		File[] files = dir.listFiles();
		
		for(File file :files){
			
			if(file.isDirectory()){//遍历删除文件
				removeDir(file);
			}else {
				System.out.println(file+":"+file.delete());
			}
		}
		//删除目录
		System.out.println(dir+":"+dir.delete());
	}	

}
