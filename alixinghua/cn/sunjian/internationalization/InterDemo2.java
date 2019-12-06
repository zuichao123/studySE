package cn.sunjian.internationalization;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * 国际化操作练习：
 * 		ResourceBundle类读取，Properties文件	
 * 
 * 		根据不同的国家输出不同国家的你好：
 * 			中文：你好
 * 			英语：hello
 * 			法语：Bonjour
 * 		分别定义不同的资源文件，此时需要定义三个资源文件，同时在定义文件的时候，需要指定好此资源文件对应的语言编码：
 * 			中文：Message_zh_CN.properties
 * 			英文：Message_en_US.properties
 * 			法文：Message_fr_FR.properties
 * 	
 * 		根据Locale所指定区域的ISO不同，得到不同的资源文件中的内容。
 * 
 * 
 * @author jack
 *
 */
public class InterDemo2 {

	public static void main(String[] args) {

		Locale zhLoc = new Locale("zh", "CN");//表示中国地区
		Locale enLoc = new Locale("en", "US");//表示美国地区
		Locale frLoc = new Locale("fr", "FR");//表示法国地区
		
		//找到中文的属性文件，需要指定中文的Locale对象
		ResourceBundle zhrb = ResourceBundle.getBundle("Message",zhLoc);//不用写后缀，自动会找到
		//找到英语的属性文件，需要指定英语的Locale对象
		ResourceBundle enrb = ResourceBundle.getBundle("Message",enLoc);//不用写后缀，自动会找到
		//找到法语的属性文件，需要指定法语的Locale对象
		ResourceBundle frrb = ResourceBundle.getBundle("Message",frLoc);//不用写后缀，自动会找到
		
		System.out.println("内容："+zhrb.getString("info"));//从资源文件中读取内容，通过key"info"去找value
		System.out.println("内容："+enrb.getString("info"));//从资源文件中读取内容，通过key"info"去找value
		System.out.println("内容："+frrb.getString("info"));//从资源文件中读取内容，通过key"info"去找value
	}

}
