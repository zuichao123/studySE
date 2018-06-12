package cn.sunjian.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.channels.FileChannel;

import cn.sunjian.utils.Path;

/**
 * java.io������ϰ��
 * 
 * 		�����ļ���
 * 
 * 	˼·һ��
 * 		1.����Դ�ļ��к�Ŀ���ļ���
 * 		2.�ж�Դ�ļ����Ƿ����,������ڣ��г��ļ����е��������ݣ������г������ݽ����жϣ�������ļ��Ͷ�д��
 * 		3.�ж�Ŀ���ļ����Ƿ���ڣ���������ھʹ����� ������ļ��У�����Ŀ��·���д������ļ��У�Ȼ���г����ļ����е��������ݣ����еݹ����...
 * 
 * 	˼·����ͨ���ļ�ͨ�������ж�д
 * 		������˼·һһ��
 * 
 * @author jack
 *
 */
public class CopyFolder {

	public static void main(String[] args) throws IOException {
		
		String srcDir = Path.deskTop()+"Lqbz1";
		String desDir = srcDir+"_bak";

		File srcPath = new File(srcDir);//Դ�ļ���	
		File desPath = new File(desDir);//Ŀ���ļ���
		
		
		if (srcPath.exists()) {			
			File[] f1 = srcPath.listFiles();//�г�Դ�ļ��е������ļ�
			copyFolder1(f1,desPath);
			copyFolder2(f1,desPath);
			copyFolder3(f1,desPath);
			
		}else {
			System.out.println("��Ҫ���Ƶ��ļ��в����ڣ�");
		}	
		
	}
	
	/*
	 *ʹ���ļ�ͨ������ʽ 
	 */
	private static void copyFolder2(File[] f1, File desPath) throws IOException {
	
		FileInputStream input = null;//�ļ�������
		FileOutputStream out = null;//�ļ������
		FileChannel fis = null;//�ļ�ͨ����
		FileChannel fos = null;//�ļ�ͨ����
		
		if (!desPath.exists()) {
			desPath.mkdir();
		}
		
		for(int i=0;i<f1.length;i++){
			if (f1[i].isFile()) {
				input = new FileInputStream(f1[i]);
				out = new FileOutputStream(desPath+File.separator+f1[i].getName());
				
				fis = input.getChannel();//�ļ�ͨ��������
				fos = out.getChannel();//�ļ�ͨ�������
				
				fis.transferTo(0, fis.size(), fos);//д���ļ�
				
				input.close();
				out.close();
				fis.close();
				fos.close();
			}
			if (f1[i].isDirectory()) {
				File des = new File(desPath+File.separator+f1[i].getName());
				des.mkdir();
				
				copyFolder2(f1[i].listFiles(), des);
			}
		}
		
		System.out.println("�����θ����ļ���ʹ�õ��ǣ��ļ�ͨ�����ķ�ʽ��");
	}
	
	/*
	 * ʹ����ͨ�ļ����롢�������ʽ
	 */
	private static void copyFolder1(File[] f1, File desPath) throws IOException {
		
		FileInputStream input = null;//�ļ�������
		FileOutputStream out = null;//�ļ������
		
		if (!desPath.exists()) {
			desPath.mkdir();
		}
		
		for(int i=0;i<f1.length;i++){			
			if (f1[i].isFile()) {
				input = new FileInputStream(f1[i]);
				out = new FileOutputStream(desPath+File.separator+f1[i].getName());
				
				int len = input.available();//��ȡ�ļ�����
				
				byte[] b = new byte[len];
				
				if(input.read(b) != -1){
					out.write(b, 0, len);
				}
				
				input.close();
				out.close();
			}
			
			if (f1[i].isDirectory()) {
				File des = new File(desPath+File.separator+f1[i].getName());
				des.mkdir();//����Ŀ¼
				
				copyFolder1(f1[i].listFiles(), des);
			}
		}
		System.out.println("�����θ����ļ���ʹ�õ��ǣ��ļ����롢������ķ�ʽ��");
	}
	
private static void copyFolder3(File[] f1, File desPath) throws IOException {
		
		BufferedReader bufr = null;//�ļ�������
		BufferedWriter bufw = null;//�ļ������
		
		if (!desPath.exists()) {
			desPath.mkdir();
		}
		
		for(int i=0;i<f1.length;i++){			
			if (f1[i].isFile()) {
				bufr = new BufferedReader(
						new InputStreamReader(
								new FileInputStream(f1[i])));
				bufw = new BufferedWriter(
						new OutputStreamWriter(
								new FileOutputStream(desPath+File.separator+f1[i].getName())));
				
				String str = null;
				while((str = bufr.readLine()) != null){
					bufw.write(str);
				}
				
				bufr.close();
				bufw.close();

			}
			
			if (f1[i].isDirectory()) {
				File des = new File(desPath+File.separator+f1[i].getName());
				des.mkdir();//����Ŀ¼
				
				copyFolder1(f1[i].listFiles(), des);
			}
		}
		System.out.println("�����θ����ļ���ʹ�õ��ǣ��ļ��������롢������ķ�ʽ��");
	}
}















