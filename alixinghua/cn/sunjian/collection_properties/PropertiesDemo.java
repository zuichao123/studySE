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
public class PropertiesDemo {

	public static void main(String[] args) throws IOException {

		Properties pro = new Properties();
		
		//设置属性
		pro.setProperty("bj", "beijing");
		pro.setProperty("nj", "nanjing");
		pro.setProperty("tj", "tianjing");
	
		//将属性写入xml文件中
		File file = new File("c:"+File.separator+"properties.xml");
		OutputStream out = new FileOutputStream(file);
		pro.storeToXML(out, "properties info");//保存属性到指定文件
		
		//读取普通xml中的属性信息
		InputStream input = new FileInputStream(file);
		pro.loadFromXML(input);//读取文件
		
		System.out.println(pro.getProperty("nj"));
		
	}

}
