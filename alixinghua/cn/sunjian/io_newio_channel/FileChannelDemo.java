package cn.sunjian.io_newio_channel;

import cn.sunjian.utils.Path;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * java.nio��Channelͨ��
 * 
 * 		FileChannel��
 * 			�ļ�ͨ����˫�������
 * 
 * @author jack
 *
 */
public class FileChannelDemo {

	public static void main(String[] args) throws IOException {
		
		String info[] = {"�й�","ɽ��ʡ","�鶴��","�͵���","�̻ƴ�","�｡"};
		
		File file = new File(Path.deskTop()+"info.txt");
		File file2 = new File(Path.deskTop()+"info2.txt");
		
		if (file.exists()) {
			file.delete();
		}
		
		FileOutputStream output = null;//�������������
		FileInputStream input = null;//��������������
		
		FileChannel fout = null;//����FileChannel�������ͨ����
		FileChannel fin = null;//����FileChannel��������ͨ����
		
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
		 * ��ȡָ���ļ��е����ݣ���д�뵽ָ���ļ���
		 */
		output = new FileOutputStream(file2);//����ʵ�������������
		fout = output.getChannel();//�õ��µ����ͨ��
		
		@SuppressWarnings("unused")
		int temp = 0;
		while((temp = fin.read(buffer)) != -1){//ͨ������ͨ����ȡд�뵽���ļ��е����ݵ���������
			buffer.flip();//���軺����
			fout.write(buffer);//���������е�����д�뵽ָ���ļ���
			buffer.clear();//��ջ����������е�״̬������λ�ûָ���ԭ��
		}
		
		fin.close();//�ر�����ͨ��
		fout.close();//�ر����ͨ��
		input.close();//�ر�������
		output.close();//�ر������	
	}

}
