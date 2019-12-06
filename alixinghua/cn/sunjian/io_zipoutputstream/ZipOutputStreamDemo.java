package cn.sunjian.io_zipoutputstream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * java.io压缩流：练习
 * 	
 * 		1.压缩文件
 * 
 * @author sunjian
 *
 */
public class ZipOutputStreamDemo {

	public static void main(String[] args) throws IOException {

		File file = new File("c:"+File.separator+"1.txt");//定义要压缩的文件
		File zipFile = new File("c:"+File.separator+"ab1.zip");//定义压缩后的文件
		
		InputStream input = null;//声明输入流对象（读）
		ZipOutputStream zipOut = null;//声明压缩流对象
		
		input = new FileInputStream(file);//实例化文件输入流
		zipOut = new ZipOutputStream(new FileOutputStream(zipFile));//实例化压缩流
		zipOut.putNextEntry(new ZipEntry(file.getName()));//设置ZinEntry对象（压缩文件的实体）
		zipOut.setComment("这是我的注释...");//添加注释
	
		int temp = 0;//接收数据
		while((temp = input.read()) != -1){//读取内容
			zipOut.write(temp);//压缩输出
		}
		
		input.close();//关闭输入流
		zipOut.close();//关闭压缩输出流
	}

}
