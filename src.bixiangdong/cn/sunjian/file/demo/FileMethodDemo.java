package cn.sunjian.file.demo;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

public class FileMethodDemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
		/**
		 * File����ĳ�������
		 * 
		 * 1,��ȡ
		 * 	1.1��ȡ�ļ�����
		 * 	1.2��ȡ�ļ�·��
		 *  1.3��ȡ�ļ���С
		 *  1��4��ȡ�ļ�ʱ�䡢�޸�ʱ��
		 *  
		 * 2.������ɾ��
		 * 	boolean
		 * 3.�ж�
		 * 	exists
		 * 4.������
		 * 	renameto
		 */
		
//		getDemo();//��ȡ
//		createAndDeleteDemo();//������ɾ��
//		isDemo();//�ж�
//		renameToDemo();//������������
		
		listRootsDemo();
		
	}
	
	public static void listRootsDemo() {
		
		File file = new File("d:\\");
		
		System.out.println("getFreeSpace:"+file.getFreeSpace());//���пռ�
		System.out.println("getTotalSpace:"+file.getTotalSpace());//�ܹ��ռ�
		System.out.println("getUsableSpace:"+file.getUsableSpace());//������������Ŀռ�
		
		
//		File [] files = File.listRoots();//��ȡ�̷���Ϣ
//		for(File file : files){
//			System.out.println(file);
//		}
		
	}

	public static void renameToDemo() {
		
		File f1 = new File("c:\\9.mp3");
		
		File f2 = new File("d:\\aa.mp3");
		
		boolean b = f1.renameTo(f2);
		System.out.println(b);
	}

	public static void isDemo() {
		
		File f = new File("aaa.txt");
		
//		f.mkdir();
		
//		boolean b = f.exists();
//		System.out.println(b);
//		//������ж��ļ��Ƿ����
		System.out.println(f.isDirectory());//�ж��Ƿ�ΪĿ¼
		System.out.println(f.isFile());//�ж��Ƿ�Ϊ�ļ�
		
	}

	public static void createAndDeleteDemo() throws IOException {
		
		/**
		 * ������ɾ�������Ͷ༶Ŀ¼
		 */
//		File dir = new File("abc");
//		boolean b = dir.mkdir();//�����ļ���	
//		boolean b1 = dir.delete();//ɾ���ļ��У����Ŀ¼�������ݲ���ɾ��
		
//		File dir = new File("abc\\dd\\ee\\ff\\jj");
//		dir.mkdirs();//�����༶Ŀ¼
//		dir.delete();//ɾ����ʱjj����ߵ�
		
		
		
		
		/**
		 * �ļ��Ĵ�����ɾ��
		 * 
		 */
		
//		File file = new File("file.txt");
		
		/*
		 * ���������һ��������ļ������ھʹ�����������ڣ��Ͳ�����
		 * 
		 */
//		boolean b = file.createNewFile();
//		
//		System.out.println(b);
		
		/*
		 * 
		 */
		
//		boolean b1 = file.delete();  //file.deleteOnExit();�˳�ʱ�Զ�ɾ��
//		
//		System.out.println(b1);
		
	}

	public static void getDemo(){
		File file = new File("a.txt");
		
		String name = file.getName();
		
		String path = file.getAbsolutePath();//����·������ͷ���̷����Ǿ��ԣ�û���̷�������ԣ�
		String path1 = file.getPath();//���·����û��ָ������
		
		long len = file.length();//�ļ�����
		
		long time = file.lastModified();//���һ���޸ĵ�ʱ��;�жϼ���ʱ�䣬�����¶�ȡ�ļ�
		Date date = new Date(time);
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG);
		String str_time = dateFormat.format(date);
		
		String parent = file.getParent();//��ȡ��Ŀ¼
		
		
		System.out.println("name:"+name);
		System.out.println("path:"+path);
		System.out.println("path1:"+path1);
		System.out.println("len:"+len);
		System.out.println("time:"+str_time);
		System.out.println("parent:"+parent);
		
		
	}
	
	
	

}
