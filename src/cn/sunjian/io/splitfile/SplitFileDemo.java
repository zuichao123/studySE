package cn.sunjian.io.splitfile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;


/**
 * �ļ��и���
 * 
 * @author jack
 *
 */

public class SplitFileDemo {

	private static final int SIZE = 1024*1024;

	public static void main(String[] args) throws IOException {

		//����Ҫ�и���ļ�
		File file = new File("c:\\0.mp3");
		
//		splitFile(file);
		splitFile_2(file);
	}
	
	
	/**
	 * �и��ļ�����¼�������ļ���
	 * 
	 * @param file
	 * @throws IOException
	 */
	
	public static void splitFile_2(File file) throws IOException {

		//�ö�ȡ������Դ�ļ�
		FileInputStream fis = new FileInputStream(file);
		//����һ��1M�Ļ�����
		byte[] buf = new byte[SIZE];
		
		//����Ŀ��
		FileOutputStream fos = null;
		
		int len = 0;
		int count = 1;
		
		/*
		 * �и��ļ�ʱ�������¼�����и��ļ������ƣ��Լ��и������Ƭ�ļ��ĸ������Է����ںϲ���
		 * �����ϢΪ�˽���������ʹ�ü�ֵ�Եķ�ʽ���õ���Properties����
		 * 
		 */
		
		Properties prop = new Properties();
		
		//�����ļ��и��Ĵ��·��
		File dir = new File("c:\\partfiles");
		//�ж�Ŀ¼�Ƿ������������ھʹ���һ��
		if (!dir.exists()) {
			dir.mkdirs();
		}
		
		//ѭ����ȡԴ�ļ��е����ݣ�
		while((len=fis.read(buf))!=-1){
			fos = new FileOutputStream(new File(dir,(count++)+".part"));
			fos.write(buf,0,len);
			fos.close();
		}
		
		//�����и��ļ�����Ϣ���浽prop������
		prop.setProperty("partcount", count+"");//��Ƭ�ļ��ĸ���
		prop.setProperty("filename", file.getName());//��Ƭ�ļ�������
		
		fos = new FileOutputStream(new File(dir,count+".properties"));
		
		//��prop�����е����ݴ洢���ļ���
		prop.store(fos, "save file info!");
		
		
		fos.close();
		fis.close();
				
	}
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * �и��ļ�
	 * 
	 * @param file
	 * @throws IOException
	 */

	public static void splitFile(File file) throws IOException{
		
		//�ö�ȡ������Դ�ļ�
		FileInputStream fis = new FileInputStream(file);
		//����һ��1M�Ļ�����
		byte[] buf = new byte[SIZE];
		
		//����Ŀ��
		FileOutputStream fos = null;
		
		int len = 0;
		int count = 1;
		
		//�����ļ��и��Ĵ��·��
		File dir = new File("c:\\partfiles");
		//�ж�Ŀ¼�Ƿ������������ھʹ���һ��
		if (!dir.exists()) {
			dir.mkdirs();
		}
		
		//ѭ����ȡԴ�ļ��е����ݣ�
		while((len=fis.read(buf))!=-1){
			fos = new FileOutputStream(new File(dir,(count++)+".part"));
			fos.write(buf,0,len);
			fos.close();
		}	
		
		fos.close();
		fis.close();
		
	}

}
