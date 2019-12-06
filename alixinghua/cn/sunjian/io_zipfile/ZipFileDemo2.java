package cn.sunjian.io_zipfile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

/**
 * java.io压缩流：解压缩练习ZipInputStream
 * 
 * 		1.解压缩文件夹
 * 
 * @author sunjian
 *
 */
public class ZipFileDemo2 {

	public static void main(String[] args) throws IOException, IOException {
		File file = new File("c:"+File.separator+"ab.zip");//指定解压缩的文件夹
		File outFile = null;//定义输出文件的时候要用的文件夹（解压后的文件存放的文件夹）
	
		ZipFile zipFile = new ZipFile(file);//实例化ZipFile对象（解压缩流的对象，指定解压缩的文件）
		ZipInputStream zipInput = null;//定义压缩输入流(读取压缩文件夹中的实体)
		ZipEntry entry = null;//定义每一个压缩实体
		OutputStream out = null;//定义输出流，用于输出每一个实体内容
		InputStream input = null;//定义输入流，读取没有ZipEntry
		
		zipInput = new ZipInputStream(new FileInputStream(file));//实例化ZipInputStream对象（指定要读取实体的压缩文件夹）
		
		while((entry = zipInput.getNextEntry()) != null){//判断，如果压缩文件夹中的还有下一个实体（得到一个压缩实体）
			System.out.println("实体名称："+entry.getName());
			
			outFile = new File("c:"+File.separator+entry.getName());//定义每一个输出文件
			
			if (!outFile.getParentFile().exists()) {//判断，如果输出文件夹不存在
				outFile.getParentFile().mkdir();//创建文件夹
			}
			if (!outFile.exists()) {//判断，如果输出的文件不存在
				outFile.createNewFile();//创建文件
			}
			
			input = zipFile.getInputStream(entry);//得到每一个实体的输入流
			out = new FileOutputStream(outFile);//实例化文件输出流
			
			int temp = 0;//接收内容
			while((temp = input.read()) != -1){//读取内容
				out.write(temp);//写入（输出）内容
			}
			
			input.close();//关闭输入流
			out.close();//关闭输出流
		}
		zipFile.close();//关闭压缩流
		zipInput.close();//关闭压缩输入流
	}

}
