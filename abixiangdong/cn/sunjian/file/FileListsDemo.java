package cn.sunjian.file;

import java.io.File;

import cn.sunjian.filter.FilterByJava;
import cn.sunjian.filter.SuffixFilter;

public class FileListsDemo {

	public static void main(String[] args) {
		
		FileListDemo();
//		FileListDemo_2();
//		FileListDemo_3();
		FileListDemo_4();
	}

	/*
	 * ���ݴ����ָ����׺������ȡָ�����ļ�
	 */
	public static void FileListDemo_4() {
		
		File dir = new File("c:\\");
		
		String[] names = dir.list(new SuffixFilter(".java"));
		
		for(String name:names){
			System.out.println(name);
		}
		
	}

	/*
	 * ��ȡc���в������ص��ļ���Ŀ¼
	 */
	public static void FileListDemo_3() {

		File dir = new File("c:\\");
		
		File[] files = dir.listFiles();
		
		for(File file : files){
			System.out.println(file);
		}
	}

	/*
	 * ��ȡc�������е�.java�ļ�
	 */
	public static void FileListDemo_2() {
		
		File dir = new File("c:\\");
		
		String [] names = dir.list(new FilterByJava());
		
		for(String name:names){
			System.out.println(name);
		}
		
	}

	/*
	 * ��ȡ��ǰĿ¼�����е�Ŀ¼���Ƽ��ļ����ƣ����������ļ�
	 * ����list������file�����з�ת�ı�����Ŀ¼
	 * ����ᷢ����ָ���쳣
	 * ������ʵ�ʱϵͳ��ľҲ�ᷢ����ָ���쳣
	 * 
	 * File file = new File("c:\\abc");
	 * ���Ŀ¼���ڣ�����û�����ݣ��᷵��һ�����飬���ǳ���Ϊ��
	 * 
	 * ��ȡ���еġ�java�ļ�
	 * 
	 * 
	 */
	
	public static void FileListDemo() {
		
		File file = new File("c:\\");
		
		String [] names = file.list();
		
		for(String name:names){
			System.out.println(name);
		}
		
	}

}
