package cn.sunjian.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * 复制文件夹
 * 
 * 将一个文件夹中的内容复制到另一个文件下
 * 
 * @author jack
 *
 */
@SuppressWarnings("unused")
public class CopyFolderDemo {

	public static void main(String[] args) throws IOException {
		
		//源目录
		String srcDir = "C:\\Users\\jack\\Desktop\\aa";
		//目的目录
		String destDir = srcDir+"1_6";
		
		//通过File对象获取源目录下的所有的目录和文件，缓存到File数组中
		File srcpath = new File(srcDir);
		File[] fl = srcpath.listFiles();
		
		//定义一个File对象关联目的目录
		File file = new File(destDir);
		
		//计时
		comTime();
		//调用复制文件夹方法
//		copyFolder(fl, file);
		copyFolder_2(fl, file);
		//计时
		comTime();
		    
	}
	
//########################################方法区#######################################
	
	/**
	 * channel通道
	 * 通道复制文件方法
	 * 
	 * @param fl
	 * 	源文件夹
	 * @param file
	 * 	目的文件夹
	 * @throws IOException
	 * 	异常
	 * @file.separator
	 * 	目录间隔符号\\
	 */

	@SuppressWarnings("static-access")
	public static void copyFolder_2(File[] fl, File file) throws IOException {
		//创建字节输入流对象
		FileInputStream fis = null;
		//创建字节输出流对象
		FileOutputStream fos = null;
		//创建文件通道类对象
		FileChannel ficin = null;
		FileChannel ficout = null;

		//判断目的目录是否存在，如果不存在，就创建
		if (!file.exists()) {
			file.mkdir();
		}
		
		//循环判断File数组中的内容
		for (int i = 0; i < fl.length; i++) {
			//如果内容为文件
			if (fl[i].isFile()) {
				//创建字节输入流对象，关联：此文件
				fis = new FileInputStream(fl[i]);
				//创建字节输出流对象，关联：目的文件
				fos = new FileOutputStream(file.getPath()+file.separator+fl[i].getName());
				
				//获取字节输入流的文件通道
				ficin = fis.getChannel();
				//获取字节输出流的文件通道
				ficout = fos.getChannel();
				
				//将字节输入流通道的数据，写入到字节输出流通道中
				ficin.transferTo(0, ficin.size(), ficout);
			}
			//如果内容为目录
			if (fl[i].isDirectory()) {
				//创建File对象，关联：此目录
				File des = new File(file.getPath()+file.separator+fl[i].getName());
				//通过File对象，创建此目录
				des.mkdir();
				
				/*
				 * 递归调用
				 * 复制目录方法
				 */
				copyFolder_2(fl[i].listFiles(), des);
			}
			
		}	
		
	}


//################################################################################################
	
	
	/**
	 * 计算时间方法
	 */
	
	public static void comTime() {

//		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
//		String time = df.format(date);
		String time = df.format(System.currentTimeMillis());
		
		System.out.println(time);
	}

	/**
	 * 普通
	 * 复制文件夹方法
	 * 
	 * @param fl
	 * 	源文件夹
	 * @param file
	 * 	目的文件夹
	 * @file.separator
	 * 	目录间隔符号\\
	 */
	
	@SuppressWarnings("static-access")
	public static void copyFolder(File[] fl, File file) {

		
		//判断目的文件件是否存在，如果不存在就创建
		if (!file.exists())
			file.mkdir();
		
		//循环判断File数组中的内容
		for (int i = 0; i < fl.length; i++) {
			
			//如果File数组中的内容是文件
			if (fl[i].isFile()) {
				try {
					//创建文件字节输入流对象，关联：当前文件
					FileInputStream fis = new FileInputStream(fl[i]);
					//创建文件字节输出流对象，关联：目的文件
					FileOutputStream out = new FileOutputStream(new File(file.getPath()/*目的目录的根路径*/+file.separator/*目录分隔符\\*/+fl[i].getName()/*文件名*/));
					//获取文件中的字节长度
					int count = fis.available();
					//定义一个符合当前文件的大小的byte数组，用来缓存当前数据
					byte[] data = new byte[count];
					//通过字节输入流读取缓存文件数组，并通过字节输出流对象调用write方法，将所有内容写入到目的目录下的目的文件中
					if ((fis.read(data))!=-1) {
						out.write(data);
					}
					//关闭输出流
					out.close();
					//关闭输入流
					fis.close();
					
				} catch (Exception e) {

					e.printStackTrace();
				}
			}
			//如果File数组中的内容是目录
			if (fl[i].isDirectory()) {
				//定义File对象，关联：此目录
				File des = new File(file.getPath()+file.separator+fl[i].getName());
				//通过File对象，创建此目录
				des.mkdir();
				/**
				 * 递归调用
				 * 复制目录方法（传入当前目录中的所有目录和文件, 当前目的目录）
				 */
				copyFolder(fl[i].listFiles(), des);
				
			}
			
		}
		
	}

}
