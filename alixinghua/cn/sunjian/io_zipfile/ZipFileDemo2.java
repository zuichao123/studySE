package cn.sunjian.io_zipfile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

/**
 * java.ioѹ��������ѹ����ϰZipInputStream
 * 
 * 		1.��ѹ���ļ���
 * 
 * @author sunjian
 *
 */
public class ZipFileDemo2 {

	public static void main(String[] args) throws IOException, IOException {
		File file = new File("c:"+File.separator+"ab.zip");//ָ����ѹ�����ļ���
		File outFile = null;//��������ļ���ʱ��Ҫ�õ��ļ��У���ѹ����ļ���ŵ��ļ��У�
	
		ZipFile zipFile = new ZipFile(file);//ʵ����ZipFile���󣨽�ѹ�����Ķ���ָ����ѹ�����ļ���
		ZipInputStream zipInput = null;//����ѹ��������(��ȡѹ���ļ����е�ʵ��)
		ZipEntry entry = null;//����ÿһ��ѹ��ʵ��
		OutputStream out = null;//������������������ÿһ��ʵ������
		InputStream input = null;//��������������ȡû��ZipEntry
		
		zipInput = new ZipInputStream(new FileInputStream(file));//ʵ����ZipInputStream����ָ��Ҫ��ȡʵ���ѹ���ļ��У�
		
		while((entry = zipInput.getNextEntry()) != null){//�жϣ����ѹ���ļ����еĻ�����һ��ʵ�壨�õ�һ��ѹ��ʵ�壩
			System.out.println("ʵ�����ƣ�"+entry.getName());
			
			outFile = new File("c:"+File.separator+entry.getName());//����ÿһ������ļ�
			
			if (!outFile.getParentFile().exists()) {//�жϣ��������ļ��в�����
				outFile.getParentFile().mkdir();//�����ļ���
			}
			if (!outFile.exists()) {//�жϣ����������ļ�������
				outFile.createNewFile();//�����ļ�
			}
			
			input = zipFile.getInputStream(entry);//�õ�ÿһ��ʵ���������
			out = new FileOutputStream(outFile);//ʵ�����ļ������
			
			int temp = 0;//��������
			while((temp = input.read()) != -1){//��ȡ����
				out.write(temp);//д�루���������
			}
			
			input.close();//�ر�������
			out.close();//�ر������
		}
		zipFile.close();//�ر�ѹ����
		zipInput.close();//�ر�ѹ��������
	}

}
