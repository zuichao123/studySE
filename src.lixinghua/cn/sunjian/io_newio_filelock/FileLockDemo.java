package cn.sunjian.io_newio_filelock;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

import cn.sunjian.utils.Path;

/**
 * java��io��
 * 
 * 		FileLock���ļ���
 * 			�����ļ���
 * 
 * @author jack
 *
 */
public class FileLockDemo {

	public static void main(String[] args) throws IOException {

		String info[] = {"�й�","ɽ��ʡ","�鶴��","�͵���","�̻ƴ�","�｡"};
		
		File file = new File(Path.deskTop()+"info.txt");
		
		if (file.exists()) {
			file.delete();
		}
		
		FileOutputStream output = null;//�������������
		
		FileChannel fout = null;//����FileChannel�������ͨ����
		
		output = new FileOutputStream(file);//ʵ���������
		
		fout = output.getChannel();//�õ������ͨ��
		
		ByteBuffer buffer = ByteBuffer.allocate(1024);//����һ��������
		
		/*
		 * ���ַ����������ݣ�д�뵽ָ���ļ�
		 * ���е�ֵ�Ի�����Ϊ׼��
		 */
		for(int i=0;i<info.length;i++){
			buffer.put(info[i].getBytes());//�ַ�����Ϊ�ֽ�����Ž�������֮��
		}
		
		buffer.flip();//���軺����
		fout.write(buffer);//д�������������ݣ����������е��ַ������飬д�뵽�ļ���
		buffer.clear();//��ջ�����
		
		
		/*
		 * �ļ���
		 */
		FileLock lock = fout.tryLock();//���ж�ռ���Ĳ���
		
		if (lock != null) {
			System.out.println(file.getName()+"�ļ�����10�롣����");
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			lock.release();//�ͷ���
			System.out.println(file.getName()+"�ļ��������������");
		}
		fout.close();//�ر����ͨ��
		output.close();//�ر������
	}

}
