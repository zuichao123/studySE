package cn.sunjian.io.charset;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 字符编码：练习
 * 	
 * 		设置编码格式
 * 
 * @author jack
 *
 */
public class CharSetDemo2 {

	public static void main(String[] args) throws IOException {

		File file = new File("c:"+File.separator+"text.txt");//实例化file类
		
		OutputStream out = new FileOutputStream(file);//实例化输出流
		
		byte[] b = "你好，中国！".getBytes("ISO8859-1");
		
		out.write(b);//保存，写入文件
		
		out.close();//关闭输出流
	}

}
