package cn.sunjian.io_newio_buffer;

import java.nio.ByteBuffer;

/**
 * java新IO：ByteBuffer缓冲区
 * 
 * 		直接缓冲区：
 * 			提高尽可能的性能；
 * 
 * @author jack
 *
 */
public class ByteBufferDemo {

	public static void main(String[] args) {
		
		ByteBuffer buf = ByteBuffer.allocateDirect(10);//准备出10个大小的缓冲区
		
		byte temp[] = {1,3,5,7,9};//设置内容
		buf.put(temp);//设置一组内容
	
		buf.flip();//重设缓冲区
		
		System.out.println("缓存区中的内容：");
		while(buf.hasRemaining()){
			int i = buf.get();
			System.out.print(i+"、");
		}
		
	}
}
