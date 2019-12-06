package cn.sunjian.internationalization;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * 国际化操作练习：
 * 		
 * 		java新特性：使用一个类代替资源文件
 * 
 * 		以中文为例：
 * 
 * @author jack
 *
 */

public class InterDemo5 {

	public static void main(String[] args) {
		
		Locale zhLoc = new Locale("zh","CN");//表示中国地区
		
		ResourceBundle zhrb = ResourceBundle.getBundle("Message",zhLoc);//找到中文的 属性文件，需要指定中文的locale对象
		
		String str1 = zhrb.getString("info");
		
		System.out.println("中文："+ MessageFormat.format(str1, "孙健ewq"));//动态文本		
		
		print();
	}

	
	
	
	
	private static void print() {
		Message_zh_CN mzc = new Message_zh_CN();
		
		Object[][] arr = mzc.getContents();
		
		for(int x=0;x<arr.length;x++){
			for(int y=0;y<arr.length-1;y++){
				System.out.print(arr[x][y]+"、");
			}
			System.out.println();
		}
	}
}
