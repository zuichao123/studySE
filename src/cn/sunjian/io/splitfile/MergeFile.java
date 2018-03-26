package cn.sunjian.io.splitfile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Properties;


/**
 * 合并文件
 * 
 * @author jack
 *
 */

public class MergeFile {

	public static void main(String[] args) throws IOException {
		
		//定义合并的路径（在当前路径中将当前所有的碎片文件合并）
		File dir = new File("c:\\partfiles");	
		
//		mergeFile(dir);
		
		mergeFile_2(dir);

	}

	/**
	 * 合并文件
	 * 
	 * @param dir
	 * @throws IOException 
	 */
	public static void mergeFile_2(File dir) throws IOException {

		/*
		 * 获取指定目录下的配置文件对象===============================
		 */
		
		File[] files = dir.listFiles(new SuffixFilter(".properties"));
		
		if ((files.length)!=1) 
			throw new RuntimeException(dir+",该目录下没有Properties扩展名的文件或者不唯一");
		
		//记录配置文件对象。
		File confile = files[0];
		
		
		/*
		 * 获取配置文件的信息=======================================
		 */
		
		
		//获取该文件中的信息
		Properties prop = new Properties();
		//关联
		FileInputStream fis = new FileInputStream(confile);
		//加载
		prop.load(fis);
		//拿内容
		String filename = prop.getProperty("filename");
		int count = Integer.parseInt(prop.getProperty("partcount"));//将返回的字符串转换为整形
		
		/*
		 * 获取所有碎片文件==========================================
		 */
		
		
		//获取该目录下的所有碎片文件
		File[] partFiles = dir.listFiles(new SuffixFilter(".part"));
		
		//判断碎片文件的length
		if (partFiles.length!=(count-1)) {
			throw new RuntimeException("碎片文件不符合要求，个数不对！应该"+count+"个");
		}
		
		
		/*
		 * 将碎片文件和流对象关联并存储到集合中=============================
		 */
		
		ArrayList<FileInputStream> al = new ArrayList<FileInputStream>();
		
		//每一个碎片都跟流关联
		for(int x=1; x<partFiles.length; x++){
			al.add(new FileInputStream(partFiles[x]));
		}
		
		
		/*
		 * 将多个流合并成一个序列流=====================================
		 */
		
		Enumeration<FileInputStream> en = Collections.enumeration(al);
		SequenceInputStream sis = new SequenceInputStream(en);
		
		
		/*
		 * 读写操作===============================================
		 */
		
		
		//创建目的
		FileOutputStream fos = new FileOutputStream(new File(dir,filename));
		
		byte[] buf = new byte[1024];
		
		int len = 0;
		while((len=sis.read(buf))!=-1){
			fos.write(buf, 0, len);
		}
		
		fos.close();
		sis.close();
		
		
	}

	
	
	
	
	/**
	 * 合并文件
	 * 
	 * @param dir
	 * @throws IOException
	 */
	public static void mergeFile(File dir) throws IOException{
		
		ArrayList<FileInputStream> al = new ArrayList<FileInputStream>();
		
		for(int x =1; x<=3; x++){
			al.add(new FileInputStream(new File(dir,x+".part")));
			
		}
		
		Enumeration<FileInputStream> en = Collections.enumeration(al);
		SequenceInputStream sis = new SequenceInputStream(en);
		
		//创建目的
		FileOutputStream fos = new FileOutputStream(new File(dir,"1.bmp"));
		
		byte[] buf = new byte[1024];
		
		int len = 0;
		while((len=sis.read(buf))!=-1){
			fos.write(buf, 0, len);
		}
		
		fos.close();
		sis.close();
	
	}
	
	
}
