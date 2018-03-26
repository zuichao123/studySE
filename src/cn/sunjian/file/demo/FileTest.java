package cn.sunjian.file.demo;

import java.io.File;

/**
 * ���󣺶�ָ��Ŀ¼�����������ݵ��г���������Ŀ¼�е����ݣ�
 * Ҳ�������Ϊ��ȱ���
 * 
 * @author jack
 * 
 * list()��ֻ���ļ�����
 * listFiles():
 *
 */

public class FileTest {

	public static void main(String[] args) {

		File dir = new File("f:\\");
		
		listAll(dir,0);
	}

	//��Ŀ¼�е�����
	public static void listAll(File dir,int level) {
		
		System.out.println(getSpace(level)+dir.getName());
		
		level++;
		
		//��ȡָ��Ŀ¼�µ�ǰ�������ļ��л����ļ�����
		File[] files = dir.listFiles();
		
		for(int x = 0; x<files.length; x++){
			
			
			if (files[x].isDirectory()) {
				
				listAll(files[x],level);//�ݹ�
				
			}else
//			System.out.println(files[x].getAbsolutePath());
				System.out.println(getSpace(level)+files[x].getName());
		}
		
	}

	//�г�Ŀ¼�㼶
	public static String getSpace(int level) {

		StringBuilder sb = new StringBuilder();
		
		sb.append("|--");
		for(int x= 0; x<level; x++){
			sb.insert(0,"| ");
		}
		
		return sb.toString();
	}

}
