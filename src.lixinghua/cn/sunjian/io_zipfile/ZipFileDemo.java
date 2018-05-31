package cn.sunjian.io_zipfile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * java.io压缩流：解压缩练习ZipFile
 * 
 * 		1.解压缩文件
 * 
 * @author sunjian
 *
 */
public class ZipFileDemo {

	public static void main(String[] args) throws IOException, IOException {
		File file = new File("c:"+File.separator+"ab1.zip");//指定解压缩的文件
		File outputFile = new File("c:"+File.separator+"ab2.txt");//指定解压后的文件
	
		ZipFile zipFile = new ZipFile(file);//实例化zip对象
		ZipEntry entry = zipFile.getEntry("1.txt");//得到一个压缩实体
		InputStream input = zipFile.getInputStream(entry);//得到一个压缩实体文件的输入流
		OutputStream out = new FileOutputStream(outputFile);//实例化输出流
		
		int temp = 0;
		while((temp = input.read()) != -1){//读压缩实体文件的内容
			out.write(temp);//将内容写出到文件
		}
		
		zipFile.close();//关闭解压缩流
		input.close();//关闭输入流
		out.close();//关闭输出流
	}

	/*
	 * 缺点：必须知道压缩文件中的每一个压缩实体的名称才可以进行解压缩操作。
	 */
}
