package cn.sunjian.io.inputstreamwriter;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * InputStreamReader类练习：读（使用字符流读取字节流的内容）
 * 
 * 		使用字符输入流输入（读取）字节输入流的内容
 * 
 * @author jack
 *
 */
public class InputStreamReaderDemo {

	public static void main(String[] args) throws IOException {

		File file = new File("c:"+File.separator+"text2.txt");//定义文件
		
		Reader reader = null;//定义字符输入流对象
		
		//将字节流变为字符流
		reader = new InputStreamReader(new FileInputStream(file));//子类实例化父类对象，InputStreamReader接收的是一个字节流
	
		char[] c = new char[1024];
	
		int temp = 0;
		int len = 0;
		
		while((temp = reader.read()) != -1){
			c[len] = (char)temp;
			len++;
		}
		
		System.out.println("内容："+new String(c,0,len));
		
		reader.close();
	}

}
