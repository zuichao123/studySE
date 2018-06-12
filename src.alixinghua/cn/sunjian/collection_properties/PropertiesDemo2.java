package cn.sunjian.collection_properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

/**
 * Properties类：
 * 
 * 		设置属性、得到属性
 * 
 * @author sunjian
 *
 */
public class PropertiesDemo2 {

	public static void main(String[] args) throws IOException {

		Properties pro = new Properties();
		
		//设置属性
		pro.setProperty("bj", "beijing");
		pro.setProperty("nj", "nanjing");
		pro.setProperty("tj", "tianjing");
		
		//得到属性，如果有输出；如果没有，输出默认值（没有发现）
		System.out.println(pro.getProperty("nj","没有发现"));
		System.out.println(pro.getProperty("nj2","没有发现"));
	
		//将属性写入普通文件中
		File file = new File("c:"+File.separator+"properties.txt");
		OutputStream out = new FileOutputStream(file);
		pro.store(out, "properties info");//保存属性到指定文件
		
		//读取普通文件中的属性信息
		InputStream input = new FileInputStream(file);
		pro.load(input);//读取文件
		System.out.println(pro.getProperty("nj"));
		
	}

}
