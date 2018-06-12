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
 * 		1.压缩文件夹
 * 
 * @author sunjian
 *
 */
public class ZipOutputStreamDemo2 {

	public static void main(String[] args) throws IOException {

		File file = new File("c:"+File.separator+"ab");//定义要压缩的文件
		File zipFile = new File("c:"+File.separator+"ab.zip");//定义压缩后的文件
		
		InputStream input = null;//声明输入流对象（读）
		ZipOutputStream zipOut = null;//声明压缩流对象
		
		zipOut = new ZipOutputStream(new FileOutputStream(zipFile));//实例化压缩流
		
		zipOut.setComment("this is my comments...");//添加注释
		int temp = 0;//接收数据

		if (file.isDirectory()) {//判断如果是目录
			File lists[] = file.listFiles();//列出目录中所有的文件
			
			for(int i=0;i<lists.length;i++){
				input = new FileInputStream(lists[i]);//实例化文件输入流
				zipOut.putNextEntry(new ZipEntry(
						file.getName()+File.separator+lists[i].getName()));//设置每一个ZipEntry对象(压缩文件的实体)
				
				while((temp = input.read()) != -1){//读取内容
					zipOut.write(temp);//压缩输出
				}		
				input.close();//关闭输入流
			}
		}	
		zipOut.close();//关闭压缩输出流
	}

}
