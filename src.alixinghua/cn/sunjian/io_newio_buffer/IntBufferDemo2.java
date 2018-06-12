package cn.sunjian.io_newio_buffer;

import java.nio.IntBuffer;

/**
 * java��IO��buffer������
 * 
 * 		�����ӻ��������޸����ݣ�
 * 
 * @author jack
 *
 */
public class IntBufferDemo2 {

	public static void main(String[] args) {
		
		IntBuffer buf = IntBuffer.allocate(10);//׼����10����С�Ļ�����
		
		IntBuffer subbuf = null;//�����ӻ�����
		IntBuffer subread = null;//����ֻ���ӻ�����
		
		for(int i=0;i<10;i++){
			buf.put(2 * i + 1);//�����������м���10������
		}
		
		buf.flip();//���軺����
		
		System.out.println("�޸�֮ǰ�������е����ݣ�");
		while(buf.hasRemaining()){
			int i = buf.get();
			System.out.print(i+"��");
		}
		
		/*
		 * �ӻ�����
		 * ��Ҫͨ��slice()���������ӻ�����[���Ǳ�������position��limit]
		 */
		buf.position(2);
		buf.limit(8);
		subbuf = buf.slice();//�����ӻ�����
		
		for(int i=0;i<subbuf.capacity();i++){//iС���ӻ��������������
			int temp = subbuf.get(i);//�õ��ӻ���������ֵ
			subbuf.put(temp-1);//�޸�û����ֵ-1�����ż��
		}
		
		buf.flip();//���軺����
		buf.limit(buf.capacity());//��limit���û�ȥ
		
		System.out.println("\n�޸�֮�󻺴����е����ݣ�");
		while(buf.hasRemaining()){
			int i = buf.get();
			System.out.print(i+"��");
		}
		
		/*
		 * ֻ��������
		 */
		subread = buf.asReadOnlyBuffer();//����ֻ��������
		subread.flip();//���軺����
		System.out.println("\nֻ���������е����ݣ�");
		while(subread.hasRemaining()){
			int i = subread.get();
			System.out.print(i+"��");
		}
		
	}
}
