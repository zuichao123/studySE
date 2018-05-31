package cn.sunjian.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.channels.FileChannel;

import cn.sunjian.utils.Path;

/**
 * java.io操作练习：
 * 
 * 		复制文件夹
 * 
 * 	思路一：
 * 		1.定义源文件夹和目标文件夹
 * 		2.判断源文件夹是否存在,如果存在，列出文件夹中的所有内容，并对列出的内容进行判断，如果是文件就读写；
 * 		3.判断目的文件夹是否存在，如果不存在就创建； 如果是文件夹，就在目的路径中创建该文件夹，然后列出该文件夹中的所有内容，进行递归操作...
 * 
 * 	思路二：通过文件通道流进行读写
 * 		步骤与思路一一样
 * 
 * @author jack
 *
 */
public class CopyFolder {

	public static void main(String[] args) throws IOException {
		
		String srcDir = Path.deskTop()+"Lqbz1";
		String desDir = srcDir+"_bak";

		File srcPath = new File(srcDir);//源文件夹	
		File desPath = new File(desDir);//目的文件夹
		
		
		if (srcPath.exists()) {			
			File[] f1 = srcPath.listFiles();//列出源文件中的所有文件
			copyFolder1(f1,desPath);
			copyFolder2(f1,desPath);
			copyFolder3(f1,desPath);
			
		}else {
			System.out.println("您要复制的文件夹不存在！");
		}	
		
	}
	
	/*
	 *使用文件通道流方式 
	 */
	private static void copyFolder2(File[] f1, File desPath) throws IOException {
	
		FileInputStream input = null;//文件输入流
		FileOutputStream out = null;//文件输出流
		FileChannel fis = null;//文件通道流
		FileChannel fos = null;//文件通道流
		
		if (!desPath.exists()) {
			desPath.mkdir();
		}
		
		for(int i=0;i<f1.length;i++){
			if (f1[i].isFile()) {
				input = new FileInputStream(f1[i]);
				out = new FileOutputStream(desPath+File.separator+f1[i].getName());
				
				fis = input.getChannel();//文件通道输入流
				fos = out.getChannel();//文件通道输出流
				
				fis.transferTo(0, fis.size(), fos);//写入文件
				
				input.close();
				out.close();
				fis.close();
				fos.close();
			}
			if (f1[i].isDirectory()) {
				File des = new File(desPath+File.separator+f1[i].getName());
				des.mkdir();
				
				copyFolder2(f1[i].listFiles(), des);
			}
		}
		
		System.out.println("您本次复制文件夹使用的是：文件通道流的方式！");
	}
	
	/*
	 * 使用普通文件输入、输出流方式
	 */
	private static void copyFolder1(File[] f1, File desPath) throws IOException {
		
		FileInputStream input = null;//文件输入流
		FileOutputStream out = null;//文件输出流
		
		if (!desPath.exists()) {
			desPath.mkdir();
		}
		
		for(int i=0;i<f1.length;i++){			
			if (f1[i].isFile()) {
				input = new FileInputStream(f1[i]);
				out = new FileOutputStream(desPath+File.separator+f1[i].getName());
				
				int len = input.available();//获取文件长度
				
				byte[] b = new byte[len];
				
				if(input.read(b) != -1){
					out.write(b, 0, len);
				}
				
				input.close();
				out.close();
			}
			
			if (f1[i].isDirectory()) {
				File des = new File(desPath+File.separator+f1[i].getName());
				des.mkdir();//创建目录
				
				copyFolder1(f1[i].listFiles(), des);
			}
		}
		System.out.println("您本次复制文件夹使用的是：文件输入、输出流的方式！");
	}
	
private static void copyFolder3(File[] f1, File desPath) throws IOException {
		
		BufferedReader bufr = null;//文件输入流
		BufferedWriter bufw = null;//文件输出流
		
		if (!desPath.exists()) {
			desPath.mkdir();
		}
		
		for(int i=0;i<f1.length;i++){			
			if (f1[i].isFile()) {
				bufr = new BufferedReader(
						new InputStreamReader(
								new FileInputStream(f1[i])));
				bufw = new BufferedWriter(
						new OutputStreamWriter(
								new FileOutputStream(desPath+File.separator+f1[i].getName())));
				
				String str = null;
				while((str = bufr.readLine()) != null){
					bufw.write(str);
				}
				
				bufr.close();
				bufw.close();

			}
			
			if (f1[i].isDirectory()) {
				File des = new File(desPath+File.separator+f1[i].getName());
				des.mkdir();//创建目录
				
				copyFolder1(f1[i].listFiles(), des);
			}
		}
		System.out.println("您本次复制文件夹使用的是：文件缓冲输入、输出流的方式！");
	}
}















