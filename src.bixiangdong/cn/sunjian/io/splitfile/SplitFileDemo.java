package cn.sunjian.io.splitfile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;


/**
 * 文件切割器
 * 
 * @author jack
 *
 */

public class SplitFileDemo {

	private static final int SIZE = 1024*1024;

	public static void main(String[] args) throws IOException {

		//定义要切割的文件
		File file = new File("c:\\0.mp3");
		
//		splitFile(file);
		splitFile_2(file);
	}
	
	
	/**
	 * 切割文件并记录到配置文件中
	 * 
	 * @param file
	 * @throws IOException
	 */
	
	public static void splitFile_2(File file) throws IOException {

		//用读取流关联源文件
		FileInputStream fis = new FileInputStream(file);
		//定义一个1M的缓冲区
		byte[] buf = new byte[SIZE];
		
		//创建目的
		FileOutputStream fos = null;
		
		int len = 0;
		int count = 1;
		
		/*
		 * 切割文件时，必须记录著被切割文件的名称，以及切割出来碎片文件的个数，以方便于合并。
		 * 这个信息为了进行描述，使用键值对的方式，用到了Properties对象。
		 * 
		 */
		
		Properties prop = new Properties();
		
		//定义文件切割后的存放路径
		File dir = new File("c:\\partfiles");
		//判断目录是否存在如果不存在就创建一个
		if (!dir.exists()) {
			dir.mkdirs();
		}
		
		//循环读取源文件中的内容，
		while((len=fis.read(buf))!=-1){
			fos = new FileOutputStream(new File(dir,(count++)+".part"));
			fos.write(buf,0,len);
			fos.close();
		}
		
		//将别切割文件的信息保存到prop集合中
		prop.setProperty("partcount", count+"");//碎片文件的个数
		prop.setProperty("filename", file.getName());//碎片文件的名字
		
		fos = new FileOutputStream(new File(dir,count+".properties"));
		
		//将prop集合中的数据存储到文件中
		prop.store(fos, "save file info!");
		
		
		fos.close();
		fis.close();
				
	}
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * 切割文件
	 * 
	 * @param file
	 * @throws IOException
	 */

	public static void splitFile(File file) throws IOException{
		
		//用读取流关联源文件
		FileInputStream fis = new FileInputStream(file);
		//定义一个1M的缓冲区
		byte[] buf = new byte[SIZE];
		
		//创建目的
		FileOutputStream fos = null;
		
		int len = 0;
		int count = 1;
		
		//定义文件切割后的存放路径
		File dir = new File("c:\\partfiles");
		//判断目录是否存在如果不存在就创建一个
		if (!dir.exists()) {
			dir.mkdirs();
		}
		
		//循环读取源文件中的内容，
		while((len=fis.read(buf))!=-1){
			fos = new FileOutputStream(new File(dir,(count++)+".part"));
			fos.write(buf,0,len);
			fos.close();
		}	
		
		fos.close();
		fis.close();
		
	}

}
