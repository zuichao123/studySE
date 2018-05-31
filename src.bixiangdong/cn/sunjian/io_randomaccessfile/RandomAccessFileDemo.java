package cn.sunjian.io_randomaccessfile;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileDemo {

	public static void main(String[] args) throws IOException {

		/**
		 * RandomAccessFile:��������ļ���Ŀ��ֻ�����ļ�(�����ı��ļ���ý���ļ�)��
		 * ����io��ϵ�е�����
		 * 
		 * �ص㣺
		 * 1,�ö�����ܶ�������д��
		 * 2,�ö����ڲ�ά����һ��byte���飬��ͨ��ָ����Բ��������е�Ԫ�أ�
		 * 3,����ͨ��getFilePointer������ȡָ���λ�ã���ͨ��seek��������ָ���λ�á�
		 * 4,��ʵ�ö�����ǽ��ֽ���������������������˷�װ��
		 * 5,�ö����Դ����Ŀ��ֻ�����ļ���ͨ�����캯���Ϳ��Կ�����
		 * 
		 * 6��һ����߳�д��ʱ���õ��˶���
		 * 
		 */
		
		
//		writeFile();
		
//		readFile();
		
		randomWrite();
		
	}
	
	//ʹ��RandomAccessFile�������д������
	public static void randomWrite() throws IOException{
		
		RandomAccessFile raf = new RandomAccessFile("ranacc.txt", "rw");
		
		//��ָ��λ��д�����ݡ�
		raf.seek(3*8);
		
		
		raf.write("haha".getBytes());
		raf.writeInt(102);
		
		raf.close();
		
	}
	
	
	
	//ʹ��RandomAccessFile�����ȡָ�����ļ��е�����
	public static void readFile() throws IOException {

		RandomAccessFile raf = new RandomAccessFile("ranacc.txt", "r");
		
		//ͨ��seek����ָ���λ��
		raf.seek(1*8);//�漴�Ķ�ȡ��ֻҪָ��ָ���λ�ü��ɡ�
		
		byte[] buf = new byte[4];
		raf.read(buf);
		
		String name = new String(buf);
		
		int age = raf.readInt();//һ�ζ�4���ֽ�
		
		System.out.println(name);
		System.out.println(age);
		
		System.out.println("pos:"+raf.getFilePointer());//��ȡָ��λ��
		
		raf.close();
		
	}

	//ʹ��RandomAccessFile����д��һЩ��Ա��Ϣ����������������
	public static void writeFile() throws IOException{
		
		/*
		 * ����ļ������ڣ��򴴽�������ļ����ڣ�������
		 */
		RandomAccessFile raf = new RandomAccessFile("ranacc.txt", "rw");
		
		raf.write("����".getBytes());
		raf.writeInt(97);
		raf.write("Сǿ".getBytes());
		raf.writeInt(98);
		
		raf.close();
	}
	
	
}
