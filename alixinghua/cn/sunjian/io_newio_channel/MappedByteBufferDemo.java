package cn.sunjian.io_newio_channel;

import cn.sunjian.utils.Path;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * java.nio：Channel通道
 * 
 * 		MappedByteBuffer：
 * 			内存映射；
 * 				FileChannel类的三种内存映射模式：
				public static final FileChannel.MapMode READ_ONLY
					常量，只读映射模式；
				public static final FileChannel.MapMode READ_WRITE
					常量，读取/写入映射模式；
				public static final FileChannel.MapMode PRIVATE
					常量，专用（写入时拷贝）映射模式；
 * 
 * @author jack
 *
 */
public class MappedByteBufferDemo {

	public static void main(String[] args) throws IOException {
		
		String info[] = {"中国","山西省","洪洞县","淹底乡","程黄村","孙健"};
		
		File file = new File(Path.deskTop()+"info.txt");
		
		if (file.exists()) {
			file.delete();
		}
		
		FileOutputStream output = null;//声明输出流对象
		FileInputStream input = null;//声明输入流对象
		
		FileChannel fout = null;//声明FileChannel对象（输出通道）
		FileChannel fin = null;//声明FileChannel对象（输入通道）
		
		MappedByteBuffer mbbin = null;//声明内存映射对象（输出映射）
		
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
		 *内存映射 （只适合读取，读取最快）
		 */
		mbbin = fin.map(FileChannel.MapMode.READ_ONLY, 0, file.length());//设置只读映射模式
		
		byte[] date = new byte[(int)file.length()];//定义byte数组，开辟空间接收内容
		int foot = 0;//定义角标变量
		while(mbbin.hasRemaining()){
			date[foot++] = mbbin.get();//读取数据，添加到byte数组中
		}
		
		System.out.println(new String(date));//输出内容
		
		fin.close();//关闭输入通道
		input.close();//关闭输入流
	}

}
