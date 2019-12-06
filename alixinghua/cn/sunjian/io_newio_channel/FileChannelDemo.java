package cn.sunjian.io_newio_channel;

import cn.sunjian.utils.Path;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * java.nio：Channel通道
 * 
 * 		FileChannel：
 * 			文件通道的双向操作；
 * 
 * @author jack
 *
 */
public class FileChannelDemo {

	public static void main(String[] args) throws IOException {
		
		String info[] = {"中国","山西省","洪洞县","淹底乡","程黄村","孙健"};
		
		File file = new File(Path.deskTop()+"info.txt");
		File file2 = new File(Path.deskTop()+"info2.txt");
		
		if (file.exists()) {
			file.delete();
		}
		
		FileOutputStream output = null;//声明输出流对象
		FileInputStream input = null;//声明输入流对象
		
		FileChannel fout = null;//声明FileChannel对象（输出通道）
		FileChannel fin = null;//声明FileChannel对象（输入通道）
		
		output = new FileOutputStream(file);//实例化输出流
		input = new FileInputStream(file);//实例化输入流
		
		fout = output.getChannel();//得到输出的通道
		fin = input.getChannel();//得到输入的通道
		
		ByteBuffer buffer = ByteBuffer.allocate(1024);//创建一个缓冲区
		
		/*
		 * 将字符串数组内容，写入到指定文件
		 * 所有的值以缓冲区为准，
		 */
		for(int i=0;i<info.length;i++){
			buffer.put(info[i].getBytes());//字符串变为字节数组放进缓冲区之中
		}
		
		buffer.flip();//重设缓冲区
		fout.write(buffer);//写出缓冲区的内容（将缓冲区中的字符串数组，写入到文件）
		buffer.clear();//清空缓冲区
		
		fout.close();//关闭输出通道
		output.close();//关闭输出流
		
		/*
		 * 读取指定文件中的内容，并写入到指定文件中
		 */
		output = new FileOutputStream(file2);//重新实例化输出流对象
		fout = output.getChannel();//得到新的输出通道
		
		@SuppressWarnings("unused")
		int temp = 0;
		while((temp = fin.read(buffer)) != -1){//通过输入通道读取写入到的文件中的内容到缓冲区中
			buffer.flip();//重设缓冲区
			fout.write(buffer);//将缓冲区中的内容写入到指定文件中
			buffer.clear();//清空缓冲区，所有的状态变量的位置恢复到原点
		}
		
		fin.close();//关闭输入通道
		fout.close();//关闭输出通道
		input.close();//关闭输入流
		output.close();//关闭输出流	
	}

}
