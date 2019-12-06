package cn.sunjian.io_newio_buffer;

import java.nio.ByteBuffer;

/**
 * java��IO��ByteBuffer������
 * 
 * 		ֱ�ӻ�������
 * 			��߾����ܵ����ܣ�
 * 
 * @author jack
 *
 */
public class ByteBufferDemo {

	public static void main(String[] args) {
		
		ByteBuffer buf = ByteBuffer.allocateDirect(10);//׼����10����С�Ļ�����
		
		byte temp[] = {1,3,5,7,9};//��������
		buf.put(temp);//����һ������
	
		buf.flip();//���軺����
		
		System.out.println("�������е����ݣ�");
		while(buf.hasRemaining()){
			int i = buf.get();
			System.out.print(i+"��");
		}
		
	}
}
