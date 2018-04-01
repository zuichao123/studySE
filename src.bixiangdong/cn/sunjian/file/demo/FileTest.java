package cn.sunjian.file.demo;

import java.io.File;

/**
 * 需求：对指定目录进行所有内容的列车（包含子目录中的内容）
 * 也可以理解为深度遍历
 * 
 * @author jack
 * 
 * list()：只拿文件名称
 * listFiles():
 *
 */

public class FileTest {

	public static void main(String[] args) {

		File dir = new File("f:\\");
		
		listAll(dir,0);
	}

	//列目录中的内容
	public static void listAll(File dir,int level) {
		
		System.out.println(getSpace(level)+dir.getName());
		
		level++;
		
		//获取指定目录下当前的所有文件夹或者文件对象
		File[] files = dir.listFiles();
		
		for(int x = 0; x<files.length; x++){
			
			
			if (files[x].isDirectory()) {
				
				listAll(files[x],level);//递归
				
			}else
//			System.out.println(files[x].getAbsolutePath());
				System.out.println(getSpace(level)+files[x].getName());
		}
		
	}

	//列车目录层级
	public static String getSpace(int level) {

		StringBuilder sb = new StringBuilder();
		
		sb.append("|--");
		for(int x= 0; x<level; x++){
			sb.insert(0,"| ");
		}
		
		return sb.toString();
	}

}
