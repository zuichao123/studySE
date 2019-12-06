package cn.sunjian.io_newio_buffer;

import java.nio.IntBuffer;

/**
 * java新IO：buffer缓冲区
 * 
 * 		position、limit、capacity，这三个变量完成了缓冲区的操作代码；
 * 
 * @author jack
 *
 */
public class IntBufferDemo {

	public static void main(String[] args) {
		
		IntBuffer buf = IntBuffer.allocate(10);//准备出10个大小的缓冲区
		
		System.out.println("写入数据之前的：\nposition="+buf.position()+"，limit="+buf.limit()+"，capacity="+buf.capacity());
		
		int temp[] = {3,5,7,9};//定义一个数组
		
		buf.put(1);//设置一个数据
		buf.put(temp);//设置一组数据，此时已经放了5个数据
		
		System.out.println("写入数据之后的：\nposition="+buf.position()+"，limit="+buf.limit()+"，capacity="+buf.capacity());
		
		buf.flip();//重设缓冲区（在写入之前调用，改变缓冲的指针）
		
		System.out.println("准备输出数据时的：\nposition="+buf.position()+"，limit="+buf.limit()+"，capacity="+buf.capacity());
		
		System.out.println("缓存区中的内容：");
		while(buf.hasRemaining()){
			int i = buf.get();
			System.out.print(i+"、");
		}
		
	}
}
