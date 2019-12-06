package cn.sunjian.io_zipoutputstream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * java.ioѹ��������ϰ
 * 	
 * 		1.ѹ���ļ�
 * 
 * @author sunjian
 *
 */
public class ZipOutputStreamDemo {

	public static void main(String[] args) throws IOException {

		File file = new File("c:"+File.separator+"1.txt");//����Ҫѹ�����ļ�
		File zipFile = new File("c:"+File.separator+"ab1.zip");//����ѹ������ļ�
		
		InputStream input = null;//�������������󣨶���
		ZipOutputStream zipOut = null;//����ѹ��������
		
		input = new FileInputStream(file);//ʵ�����ļ�������
		zipOut = new ZipOutputStream(new FileOutputStream(zipFile));//ʵ����ѹ����
		zipOut.putNextEntry(new ZipEntry(file.getName()));//����ZinEntry����ѹ���ļ���ʵ�壩
		zipOut.setComment("�����ҵ�ע��...");//���ע��
	
		int temp = 0;//��������
		while((temp = input.read()) != -1){//��ȡ����
			zipOut.write(temp);//ѹ�����
		}
		
		input.close();//�ر�������
		zipOut.close();//�ر�ѹ�������
	}

}
