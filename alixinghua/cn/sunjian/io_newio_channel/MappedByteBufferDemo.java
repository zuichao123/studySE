package cn.sunjian.io_newio_channel;

import cn.sunjian.utils.Path;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * java.nio��Channelͨ��
 * 
 * 		MappedByteBuffer��
 * 			�ڴ�ӳ�䣻
 * 				FileChannel��������ڴ�ӳ��ģʽ��
				public static final FileChannel.MapMode READ_ONLY
					������ֻ��ӳ��ģʽ��
				public static final FileChannel.MapMode READ_WRITE
					��������ȡ/д��ӳ��ģʽ��
				public static final FileChannel.MapMode PRIVATE
					������ר�ã�д��ʱ������ӳ��ģʽ��
 * 
 * @author jack
 *
 */
public class MappedByteBufferDemo {

	public static void main(String[] args) throws IOException {
		
		String info[] = {"�й�","ɽ��ʡ","�鶴��","�͵���","�̻ƴ�","�｡"};
		
		File file = new File(Path.deskTop()+"info.txt");
		
		if (file.exists()) {
			file.delete();
		}
		
		FileOutputStream output = null;//�������������
		FileInputStream input = null;//��������������
		
		FileChannel fout = null;//����FileChannel�������ͨ����
		FileChannel fin = null;//����FileChannel��������ͨ����
		
		MappedByteBuffer mbbin = null;//�����ڴ�ӳ��������ӳ�䣩
		
		output = new FileOutputStream(file);//ʵ���������
		input = new FileInputStream(file);//ʵ����������
		
		fout = output.getChannel();//�õ������ͨ��
		fin = input.getChannel();//�õ������ͨ��
		
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
		
		fout.close();//�ر����ͨ��
		output.close();//�ر������
			
		
		/*
		 *�ڴ�ӳ�� ��ֻ�ʺ϶�ȡ����ȡ��죩
		 */
		mbbin = fin.map(FileChannel.MapMode.READ_ONLY, 0, file.length());//����ֻ��ӳ��ģʽ
		
		byte[] date = new byte[(int)file.length()];//����byte���飬���ٿռ��������
		int foot = 0;//����Ǳ����
		while(mbbin.hasRemaining()){
			date[foot++] = mbbin.get();//��ȡ���ݣ���ӵ�byte������
		}
		
		System.out.println(new String(date));//�������
		
		fin.close();//�ر�����ͨ��
		input.close();//�ر�������
	}

}
