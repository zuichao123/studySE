package cn.sunjian.networkprogramming;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * java网络编程：
 * 
 * 		URL类：
 * 
 * @author jack
 *
 */
public class URLDemo {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {

		try {
			URL url = new URL("http","http://www.mldnjava.cn",80,"/curriculum.htm");
			
			InputStream input = url.openStream();//打开输入流
			
			Scanner scan = new Scanner(input);//实例化Scanner类
			
			scan.useDelimiter("\n");//设置读取分隔符
			
			while(scan.hasNext()){
				System.out.println(scan.next());
			}
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
	}

}
