package cn.sunjian.internationalization;

import java.util.ResourceBundle;

/**
 * 国际化操作练习：
 * 		ResourceBundle类读取，Properties文件		
 * 
 * @author jack
 *
 */
public class InterDemo {

	public static void main(String[] args) {

		ResourceBundle rb = ResourceBundle.getBundle("Message");//不用写后缀，自动会找到
		
		System.out.println("内容："+rb.getString("message"));//从资源文件中读取内容，通过key"message"去找value
	}

}
