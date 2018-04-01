package cn.sunjian.file.demo;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

public class FileMethodDemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
		/**
		 * File对象的常见方法
		 * 
		 * 1,获取
		 * 	1.1获取文件名称
		 * 	1.2获取文件路径
		 *  1.3获取文件大小
		 *  1。4获取文件时间、修改时间
		 *  
		 * 2.创建与删除
		 * 	boolean
		 * 3.判断
		 * 	exists
		 * 4.重命名
		 * 	renameto
		 */
		
//		getDemo();//获取
//		createAndDeleteDemo();//创建和删除
//		isDemo();//判断
//		renameToDemo();//重命名、剪切
		
		listRootsDemo();
		
	}
	
	public static void listRootsDemo() {
		
		File file = new File("d:\\");
		
		System.out.println("getFreeSpace:"+file.getFreeSpace());//空闲空间
		System.out.println("getTotalSpace:"+file.getTotalSpace());//总共空间
		System.out.println("getUsableSpace:"+file.getUsableSpace());//可用于虚拟机的空间
		
		
//		File [] files = File.listRoots();//获取盘符信息
//		for(File file : files){
//			System.out.println(file);
//		}
		
	}

	public static void renameToDemo() {
		
		File f1 = new File("c:\\9.mp3");
		
		File f2 = new File("d:\\aa.mp3");
		
		boolean b = f1.renameTo(f2);
		System.out.println(b);
	}

	public static void isDemo() {
		
		File f = new File("aaa.txt");
		
//		f.mkdir();
		
//		boolean b = f.exists();
//		System.out.println(b);
//		//最好先判断文件是否存在
		System.out.println(f.isDirectory());//判断是否为目录
		System.out.println(f.isFile());//判断是否为文件
		
	}

	public static void createAndDeleteDemo() throws IOException {
		
		/**
		 * 创建和删除单级和多级目录
		 */
//		File dir = new File("abc");
//		boolean b = dir.mkdir();//创建文件夹	
//		boolean b1 = dir.delete();//删除文件夹，如果目录中有内容不能删除
		
//		File dir = new File("abc\\dd\\ee\\ff\\jj");
//		dir.mkdirs();//创建多级目录
//		dir.delete();//删除的时jj最里边的
		
		
		
		
		/**
		 * 文件的创建和删除
		 * 
		 */
		
//		File file = new File("file.txt");
		
		/*
		 * 和输出流不一样，如果文件不存在就创建，如果存在，就不创建
		 * 
		 */
//		boolean b = file.createNewFile();
//		
//		System.out.println(b);
		
		/*
		 * 
		 */
		
//		boolean b1 = file.delete();  //file.deleteOnExit();退出时自动删掉
//		
//		System.out.println(b1);
		
	}

	public static void getDemo(){
		File file = new File("a.txt");
		
		String name = file.getName();
		
		String path = file.getAbsolutePath();//绝对路径（打头有盘符就是绝对，没有盘符就是相对）
		String path1 = file.getPath();//相对路径，没有指定所属
		
		long len = file.length();//文件长度
		
		long time = file.lastModified();//最后一次修改的时间;判断加载时间，来重新读取文件
		Date date = new Date(time);
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG);
		String str_time = dateFormat.format(date);
		
		String parent = file.getParent();//获取父目录
		
		
		System.out.println("name:"+name);
		System.out.println("path:"+path);
		System.out.println("path1:"+path1);
		System.out.println("len:"+len);
		System.out.println("time:"+str_time);
		System.out.println("parent:"+parent);
		
		
	}
	
	
	

}
