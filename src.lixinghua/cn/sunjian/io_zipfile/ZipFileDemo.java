package cn.sunjian.io_zipfile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * java.ioѹ��������ѹ����ϰZipFile
 * 
 * 		1.��ѹ���ļ�
 * 
 * @author sunjian
 *
 */
public class ZipFileDemo {

	public static void main(String[] args) throws IOException, IOException {
		File file = new File("c:"+File.separator+"ab1.zip");//ָ����ѹ�����ļ�
		File outputFile = new File("c:"+File.separator+"ab2.txt");//ָ����ѹ����ļ�
	
		ZipFile zipFile = new ZipFile(file);//ʵ����zip����
		ZipEntry entry = zipFile.getEntry("1.txt");//�õ�һ��ѹ��ʵ��
		InputStream input = zipFile.getInputStream(entry);//�õ�һ��ѹ��ʵ���ļ���������
		OutputStream out = new FileOutputStream(outputFile);//ʵ���������
		
		int temp = 0;
		while((temp = input.read()) != -1){//��ѹ��ʵ���ļ�������
			out.write(temp);//������д�����ļ�
		}
		
		zipFile.close();//�رս�ѹ����
		input.close();//�ر�������
		out.close();//�ر������
	}

	/*
	 * ȱ�㣺����֪��ѹ���ļ��е�ÿһ��ѹ��ʵ������Ʋſ��Խ��н�ѹ��������
	 */
}
