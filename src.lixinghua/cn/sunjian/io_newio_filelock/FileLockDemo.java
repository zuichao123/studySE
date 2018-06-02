package cn.sunjian.io_newio_filelock;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

import cn.sunjian.utils.Path;

/**
 * java新io：
 * 
 * 		FileLock：文件锁
 * 			锁定文件；
 * 
 * @author jack
 *
 */
public class FileLockDemo {

	public static void main(String[] args) throws IOException {

		String info[] = {"中国","山西省","洪洞县","淹底乡","程黄村","孙健"};
		
		File file = new File(Path.deskTop()+"info.txt");
		
		if (file.exists()) {
			file.delete();
		}
		
		FileOutputStream output = null;//声明输出流对象
		
		FileChannel fout = null;//声明FileChannel对象（输出通道）
		
		output = new FileOutputStream(file);//实例化输出流
		
		fout = output.getChannel();//得到输出的通道
		
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
		
		
		/*
		 * 文件锁
		 */
		FileLock lock = fout.tryLock();//进行独占锁的操作
		
		if (lock != null) {
			System.out.println(file.getName()+"文件锁定10秒。。。");
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			lock.release();//释放锁
			System.out.println(file.getName()+"文件解除锁定。。。");
		}
		fout.close();//关闭输出通道
		output.close();//关闭输出流
	}

}
