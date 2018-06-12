package cn.sunjian.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 复制文件
 * 
 * 读取指定文件的内容，并写入到另一个指定的文件中、
 * 
 * @author jack
 *
 */

public class CopyFileDemo {

	public static void main(String[] args) throws IOException {

		String file = "C:\\Users\\jack\\Desktop\\1_Full.txt";
		String file2 = "C:\\Users\\jack\\Desktop\\2_Full.txt";
		
		copyFile(file,file2);
								
	}


	public static void copyFile(String oldPath,String newPath) throws IOException {
		
		//创建一个文件对象
		File file = new File(oldPath);

		//如果文件存在
		if (file.exists()) {
			//创建一个字节输入流对象，读取文件
			FileInputStream instream = new FileInputStream(oldPath);
			//创建一个字节输出流对象，输出文件
			FileOutputStream outStream = new FileOutputStream(newPath);
			
			//创建一个字符缓冲区
			byte[] buf = new byte[1024];
			//定义一个变量记录字符个数
			int num;
			
			/*
			 * 同过读取流对象循环读取文件中的字符，并通过输出流对象调用写入的方法，将文件中的内容写入到新文件中
			 * 判断如果字符不为空，就继续写
			 * 如果为空就停止写
			 */
			while((num=instream.read(buf))!=-1){
				outStream.write(buf,0,num);
			}
			
			//关闭流
			if (instream!=null) {
				instream.close();
			}
			if (outStream!=null) {
				outStream.close();
			}
			System.out.println("over");
		}
	}

}
