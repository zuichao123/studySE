package cn.sunjian.io.splitfile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Properties;


/**
 * �ϲ��ļ�
 * 
 * @author jack
 *
 */

public class MergeFile {

	public static void main(String[] args) throws IOException {
		
		//����ϲ���·�����ڵ�ǰ·���н���ǰ���е���Ƭ�ļ��ϲ���
		File dir = new File("c:\\partfiles");	
		
//		mergeFile(dir);
		
		mergeFile_2(dir);

	}

	/**
	 * �ϲ��ļ�
	 * 
	 * @param dir
	 * @throws IOException 
	 */
	public static void mergeFile_2(File dir) throws IOException {

		/*
		 * ��ȡָ��Ŀ¼�µ������ļ�����===============================
		 */
		
		File[] files = dir.listFiles(new SuffixFilter(".properties"));
		
		if ((files.length)!=1) 
			throw new RuntimeException(dir+",��Ŀ¼��û��Properties��չ�����ļ����߲�Ψһ");
		
		//��¼�����ļ�����
		File confile = files[0];
		
		
		/*
		 * ��ȡ�����ļ�����Ϣ=======================================
		 */
		
		
		//��ȡ���ļ��е���Ϣ
		Properties prop = new Properties();
		//����
		FileInputStream fis = new FileInputStream(confile);
		//����
		prop.load(fis);
		//������
		String filename = prop.getProperty("filename");
		int count = Integer.parseInt(prop.getProperty("partcount"));//�����ص��ַ���ת��Ϊ����
		
		/*
		 * ��ȡ������Ƭ�ļ�==========================================
		 */
		
		
		//��ȡ��Ŀ¼�µ�������Ƭ�ļ�
		File[] partFiles = dir.listFiles(new SuffixFilter(".part"));
		
		//�ж���Ƭ�ļ���length
		if (partFiles.length!=(count-1)) {
			throw new RuntimeException("��Ƭ�ļ�������Ҫ�󣬸������ԣ�Ӧ��"+count+"��");
		}
		
		
		/*
		 * ����Ƭ�ļ���������������洢��������=============================
		 */
		
		ArrayList<FileInputStream> al = new ArrayList<FileInputStream>();
		
		//ÿһ����Ƭ����������
		for(int x=1; x<partFiles.length; x++){
			al.add(new FileInputStream(partFiles[x]));
		}
		
		
		/*
		 * ��������ϲ���һ��������=====================================
		 */
		
		Enumeration<FileInputStream> en = Collections.enumeration(al);
		SequenceInputStream sis = new SequenceInputStream(en);
		
		
		/*
		 * ��д����===============================================
		 */
		
		
		//����Ŀ��
		FileOutputStream fos = new FileOutputStream(new File(dir,filename));
		
		byte[] buf = new byte[1024];
		
		int len = 0;
		while((len=sis.read(buf))!=-1){
			fos.write(buf, 0, len);
		}
		
		fos.close();
		sis.close();
		
		
	}

	
	
	
	
	/**
	 * �ϲ��ļ�
	 * 
	 * @param dir
	 * @throws IOException
	 */
	public static void mergeFile(File dir) throws IOException{
		
		ArrayList<FileInputStream> al = new ArrayList<FileInputStream>();
		
		for(int x =1; x<=3; x++){
			al.add(new FileInputStream(new File(dir,x+".part")));
			
		}
		
		Enumeration<FileInputStream> en = Collections.enumeration(al);
		SequenceInputStream sis = new SequenceInputStream(en);
		
		//����Ŀ��
		FileOutputStream fos = new FileOutputStream(new File(dir,"1.bmp"));
		
		byte[] buf = new byte[1024];
		
		int len = 0;
		while((len=sis.read(buf))!=-1){
			fos.write(buf, 0, len);
		}
		
		fos.close();
		sis.close();
	
	}
	
	
}
