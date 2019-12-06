package cn.sunjian.io_newio_buffer;

import java.nio.IntBuffer;

/**
 * java��IO��buffer������
 * 
 * 		position��limit��capacity����������������˻������Ĳ������룻
 * 
 * @author jack
 *
 */
public class IntBufferDemo {

	public static void main(String[] args) {
		
		IntBuffer buf = IntBuffer.allocate(10);//׼����10����С�Ļ�����
		
		System.out.println("д������֮ǰ�ģ�\nposition="+buf.position()+"��limit="+buf.limit()+"��capacity="+buf.capacity());
		
		int temp[] = {3,5,7,9};//����һ������
		
		buf.put(1);//����һ������
		buf.put(temp);//����һ�����ݣ���ʱ�Ѿ�����5������
		
		System.out.println("д������֮��ģ�\nposition="+buf.position()+"��limit="+buf.limit()+"��capacity="+buf.capacity());
		
		buf.flip();//���軺��������д��֮ǰ���ã��ı仺���ָ�룩
		
		System.out.println("׼���������ʱ�ģ�\nposition="+buf.position()+"��limit="+buf.limit()+"��capacity="+buf.capacity());
		
		System.out.println("�������е����ݣ�");
		while(buf.hasRemaining()){
			int i = buf.get();
			System.out.print(i+"��");
		}
		
	}
}
