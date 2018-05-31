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
 * 		1.ѹ���ļ���
 * 
 * @author sunjian
 *
 */
public class ZipOutputStreamDemo2 {

	public static void main(String[] args) throws IOException {

		File file = new File("c:"+File.separator+"ab");//����Ҫѹ�����ļ�
		File zipFile = new File("c:"+File.separator+"ab.zip");//����ѹ������ļ�
		
		InputStream input = null;//�������������󣨶���
		ZipOutputStream zipOut = null;//����ѹ��������
		
		zipOut = new ZipOutputStream(new FileOutputStream(zipFile));//ʵ����ѹ����
		
		zipOut.setComment("this is my comments...");//���ע��
		int temp = 0;//��������

		if (file.isDirectory()) {//�ж������Ŀ¼
			File lists[] = file.listFiles();//�г�Ŀ¼�����е��ļ�
			
			for(int i=0;i<lists.length;i++){
				input = new FileInputStream(lists[i]);//ʵ�����ļ�������
				zipOut.putNextEntry(new ZipEntry(
						file.getName()+File.separator+lists[i].getName()));//����ÿһ��ZipEntry����(ѹ���ļ���ʵ��)
				
				while((temp = input.read()) != -1){//��ȡ����
					zipOut.write(temp);//ѹ�����
				}		
				input.close();//�ر�������
			}
		}	
		zipOut.close();//�ر�ѹ�������
	}

}
