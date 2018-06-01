package cn.sunjian.io_newio_channel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import cn.sunjian.utils.Path;

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
		
		if (file.exists()) {
			file.delete();
		}
		
		FileOutputStream out = null;//声明输出流对象
		FileChannel fout = null;//声明FileChannel对象
		
		out = new FileOutputStream(file);//实例化输出流
		fout = out.getChannel();//得到输出的通道
		
		//所有的值以缓冲区为准，
		ByteBuffer buffer = ByteBuffer.allocate(1024);//创建一个缓冲区
		for(int i=0;i<info.length;i++){
			buffer.put(info[i].getBytes());//字符串变为字节数组放进缓冲区之中
		}
		
		buffer.flip();//重设缓冲区
		fout.write(buffer);//写出缓冲区的内容
		fout.close();
		out.close();
		
	}

}
