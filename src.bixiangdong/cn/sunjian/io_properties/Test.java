package cn.sunjian.io_properties;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 需求：
 * 获取指定目录下，指定扩展名的文件（包含子目录中的）
 * 这些文件的路径路径写入到一个文本文件中 
 * 
 * 简单说，就是建立一个指定扩展名的文件的列表
 * 
 * 思路：
 * 1，必须进行深度遍历
 * 2.要在遍历的过程中进行过滤，将符合条件的内容都存储到容器中
 * 3.按照需求对容器中内容进行遍历并将绝对路径写入到文件中
 * 
 * 
 * @author sunjian
 *
 */
public class Test {

	public static void main(String[] args) throws IOException {
		
		File dir = new File("e:\\selenium");//指定目录
		
		FilenameFilter filter = new FilenameFilter() {//定义过滤器 （内部类）
			
			@Override
			public boolean accept(File dir, String name) {
				
				return name.endsWith(".java");//返回该目录下，文件名后缀为.java的文件
			}
		};
		
		List<File> list = new ArrayList<File>();//定义集合
		
		getFiles(dir, filter, list);
		
		File destFile = new File(dir,"javalist.txt");//定义目的文件
		
		write2File(list, destFile);	
		
	}
	
	/**
	 * 对指定目录中的内容进行深度遍历，并按照指定的过滤器，进行过滤
	 * 将过滤后的内容存储到指定容器List中
	 * 
	 * @param dir
	 * @param filter
	 * @param list
	 */
	public static void getFiles(File dir/*目录*/,FilenameFilter filter/*文件名过滤*/,List<File> list/*存储符合条件内容的容器*/){

		File[] files = dir.listFiles();//获取目录下所有的内容
		
		for(File file : files){//遍历内容
			if(file.isDirectory()){//如果是目录
				//递归了
				getFiles(file, filter, list);//再对该目录进行过滤
			}else {//如果不是目录
				//对遍历到的文件进行过滤器的过滤，将符合条件File对象，存储到List集合中
				if (filter.accept(dir/*当前目录*/, file.getName()/*获取当前目录下文件的名称*/)) {//对当前目录下的文件名称通过过滤器进行过滤
					list.add(file);//将满足条件的文件添加到list集合中
				}
			}
		}
	}
	
	/**
	 * 将List集合中的内容写入到指定文件中
	 * @param list
	 * @param destFile
	 * @throws IOException
	 */
	public static void write2File(List<File> list,File destFile/*目的文件*/) throws IOException{
		
		BufferedWriter bufw = null;//字符流
		try {			
			bufw = new BufferedWriter(new FileWriter(destFile));//关联写入的文件
			for(File file:list){//遍历集合
				bufw.write(file.getAbsolutePath()/*获取此文件的绝对路径*/);//向此文件中写入
				bufw.newLine();//换行
				bufw.flush();//刷新
			}
			
			
		}/*catch(IOException e){
			throw new RuntimeException("写入失败");
		}*/finally {
			if (bufw!=null) {
				try{
					bufw.close();//关闭字符流
				}catch (IOException e){
					throw new RuntimeException("关闭失败");
				}
			}
		}
	}
	
	
	
	
	
	

}
