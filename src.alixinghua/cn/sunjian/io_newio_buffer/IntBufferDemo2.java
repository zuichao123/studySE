package cn.sunjian.io_newio_buffer;

import java.nio.IntBuffer;

/**
 * java新IO：buffer缓冲区
 * 
 * 		创建子缓冲区，修改数据；
 * 
 * @author jack
 *
 */
public class IntBufferDemo2 {

	public static void main(String[] args) {
		
		IntBuffer buf = IntBuffer.allocate(10);//准备出10个大小的缓冲区
		
		IntBuffer subbuf = null;//定义子缓冲区
		IntBuffer subread = null;//定义只读子缓冲区
		
		for(int i=0;i<10;i++){
			buf.put(2 * i + 1);//在主缓冲区中加入10个奇数
		}
		
		buf.flip();//重设缓冲区
		
		System.out.println("修改之前缓存区中的内容：");
		while(buf.hasRemaining()){
			int i = buf.get();
			System.out.print(i+"、");
		}
		
		/*
		 * 子缓冲区
		 * 需要通过slice()方法创建子缓冲区[但是必须设置position和limit]
		 */
		buf.position(2);
		buf.limit(8);
		subbuf = buf.slice();//创建子缓冲区
		
		for(int i=0;i<subbuf.capacity();i++){//i小于子缓冲区的最大容量
			int temp = subbuf.get(i);//得到子缓冲区的数值
			subbuf.put(temp-1);//修改没有数值-1，变成偶数
		}
		
		buf.flip();//重设缓冲区
		buf.limit(buf.capacity());//将limit设置回去
		
		System.out.println("\n修改之后缓存区中的内容：");
		while(buf.hasRemaining()){
			int i = buf.get();
			System.out.print(i+"、");
		}
		
		/*
		 * 只读缓冲区
		 */
		subread = buf.asReadOnlyBuffer();//创建只读缓冲区
		subread.flip();//重设缓冲区
		System.out.println("\n只读缓存区中的内容：");
		while(subread.hasRemaining()){
			int i = subread.get();
			System.out.print(i+"、");
		}
		
	}
}
