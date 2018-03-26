package cn.sunjian.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * �����ļ�
 * 
 * ��ȡָ���ļ������ݣ���д�뵽��һ��ָ�����ļ��С�
 * 
 * @author jack
 *
 */

public class CopyFileDemo {

	public static void main(String[] args) throws IOException {

		String file = "C:\\Users\\jack\\Desktop\\1_Full.txt";
		String file2 = "C:\\Users\\jack\\Desktop\\2_Full.txt";
		
		copyFile(file,file2);
								
	}


	public static void copyFile(String oldPath,String newPath) throws IOException {
		
		//����һ���ļ�����
		File file = new File(oldPath);

		//����ļ�����
		if (file.exists()) {
			//����һ���ֽ����������󣬶�ȡ�ļ�
			FileInputStream instream = new FileInputStream(oldPath);
			//����һ���ֽ��������������ļ�
			FileOutputStream outStream = new FileOutputStream(newPath);
			
			//����һ���ַ�������
			byte[] buf = new byte[1024];
			//����һ��������¼�ַ�����
			int num;
			
			/*
			 * ͬ����ȡ������ѭ����ȡ�ļ��е��ַ�����ͨ��������������д��ķ��������ļ��е�����д�뵽���ļ���
			 * �ж�����ַ���Ϊ�գ��ͼ���д
			 * ���Ϊ�վ�ֹͣд
			 */
			while((num=instream.read(buf))!=-1){
				outStream.write(buf,0,num);
			}
			
			//�ر���
			if (instream!=null) {
				instream.close();
			}
			if (outStream!=null) {
				outStream.close();
			}
			System.out.println("over");
		}
	}

}
