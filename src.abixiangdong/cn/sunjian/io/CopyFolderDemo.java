package cn.sunjian.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * �����ļ���
 * 
 * ��һ���ļ����е����ݸ��Ƶ���һ���ļ���
 * 
 * @author jack
 *
 */
@SuppressWarnings("unused")
public class CopyFolderDemo {

	public static void main(String[] args) throws IOException {
		
		//ԴĿ¼
		String srcDir = "C:\\Users\\jack\\Desktop\\aa";
		//Ŀ��Ŀ¼
		String destDir = srcDir+"1_6";
		
		//ͨ��File�����ȡԴĿ¼�µ����е�Ŀ¼���ļ������浽File������
		File srcpath = new File(srcDir);
		File[] fl = srcpath.listFiles();
		
		//����һ��File�������Ŀ��Ŀ¼
		File file = new File(destDir);
		
		//��ʱ
		comTime();
		//���ø����ļ��з���
//		copyFolder(fl, file);
		copyFolder_2(fl, file);
		//��ʱ
		comTime();
		    
	}
	
//########################################������#######################################
	
	/**
	 * channelͨ��
	 * ͨ�������ļ�����
	 * 
	 * @param fl
	 * 	Դ�ļ���
	 * @param file
	 * 	Ŀ���ļ���
	 * @throws IOException
	 * 	�쳣
	 * @file.separator
	 * 	Ŀ¼�������\\
	 */

	@SuppressWarnings("static-access")
	public static void copyFolder_2(File[] fl, File file) throws IOException {
		//�����ֽ�����������
		FileInputStream fis = null;
		//�����ֽ����������
		FileOutputStream fos = null;
		//�����ļ�ͨ�������
		FileChannel ficin = null;
		FileChannel ficout = null;

		//�ж�Ŀ��Ŀ¼�Ƿ���ڣ���������ڣ��ʹ���
		if (!file.exists()) {
			file.mkdir();
		}
		
		//ѭ���ж�File�����е�����
		for (int i = 0; i < fl.length; i++) {
			//�������Ϊ�ļ�
			if (fl[i].isFile()) {
				//�����ֽ����������󣬹��������ļ�
				fis = new FileInputStream(fl[i]);
				//�����ֽ���������󣬹�����Ŀ���ļ�
				fos = new FileOutputStream(file.getPath()+file.separator+fl[i].getName());
				
				//��ȡ�ֽ����������ļ�ͨ��
				ficin = fis.getChannel();
				//��ȡ�ֽ���������ļ�ͨ��
				ficout = fos.getChannel();
				
				//���ֽ�������ͨ�������ݣ�д�뵽�ֽ������ͨ����
				ficin.transferTo(0, ficin.size(), ficout);
			}
			//�������ΪĿ¼
			if (fl[i].isDirectory()) {
				//����File���󣬹�������Ŀ¼
				File des = new File(file.getPath()+file.separator+fl[i].getName());
				//ͨ��File���󣬴�����Ŀ¼
				des.mkdir();
				
				/*
				 * �ݹ����
				 * ����Ŀ¼����
				 */
				copyFolder_2(fl[i].listFiles(), des);
			}
			
		}	
		
	}


//################################################################################################
	
	
	/**
	 * ����ʱ�䷽��
	 */
	
	public static void comTime() {

//		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
//		String time = df.format(date);
		String time = df.format(System.currentTimeMillis());
		
		System.out.println(time);
	}

	/**
	 * ��ͨ
	 * �����ļ��з���
	 * 
	 * @param fl
	 * 	Դ�ļ���
	 * @param file
	 * 	Ŀ���ļ���
	 * @file.separator
	 * 	Ŀ¼�������\\
	 */
	
	@SuppressWarnings("static-access")
	public static void copyFolder(File[] fl, File file) {

		
		//�ж�Ŀ���ļ����Ƿ���ڣ���������ھʹ���
		if (!file.exists())
			file.mkdir();
		
		//ѭ���ж�File�����е�����
		for (int i = 0; i < fl.length; i++) {
			
			//���File�����е��������ļ�
			if (fl[i].isFile()) {
				try {
					//�����ļ��ֽ����������󣬹�������ǰ�ļ�
					FileInputStream fis = new FileInputStream(fl[i]);
					//�����ļ��ֽ���������󣬹�����Ŀ���ļ�
					FileOutputStream out = new FileOutputStream(new File(file.getPath()/*Ŀ��Ŀ¼�ĸ�·��*/+file.separator/*Ŀ¼�ָ���\\*/+fl[i].getName()/*�ļ���*/));
					//��ȡ�ļ��е��ֽڳ���
					int count = fis.available();
					//����һ�����ϵ�ǰ�ļ��Ĵ�С��byte���飬�������浱ǰ����
					byte[] data = new byte[count];
					//ͨ���ֽ���������ȡ�����ļ����飬��ͨ���ֽ�������������write����������������д�뵽Ŀ��Ŀ¼�µ�Ŀ���ļ���
					if ((fis.read(data))!=-1) {
						out.write(data);
					}
					//�ر������
					out.close();
					//�ر�������
					fis.close();
					
				} catch (Exception e) {

					e.printStackTrace();
				}
			}
			//���File�����е�������Ŀ¼
			if (fl[i].isDirectory()) {
				//����File���󣬹�������Ŀ¼
				File des = new File(file.getPath()+file.separator+fl[i].getName());
				//ͨ��File���󣬴�����Ŀ¼
				des.mkdir();
				/**
				 * �ݹ����
				 * ����Ŀ¼���������뵱ǰĿ¼�е�����Ŀ¼���ļ�, ��ǰĿ��Ŀ¼��
				 */
				copyFolder(fl[i].listFiles(), des);
				
			}
			
		}
		
	}

}
