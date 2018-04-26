package cn.sunjian.io.file;

import java.io.File;

/**
 * java_IO��ϰ��
 * 	
 * 		ʹ��list()�г�ȫ�����ݣ�
 * 		and
 * 		ʹ��listFiles()�г�ȫ�����ݣ�
 * 
 * @author jack
 *
 */
public class FileDemo3 {

	public static void main(String[] args) {

		File file = new File("c:"+File.separator);//ʵ����File�����
		
		listFiles(file);
		
		System.out.println("******************************");
		
		list(file);
		
	}

	private static void list(File file) {

		String files[] = file.list();//�г�����Ŀ¼�е�����
		for(int i=0;i<files.length;i++){
			System.out.println(files[i]);
		}
	}

	private static void listFiles(File file) {

		File files[] = file.listFiles();//�г�ȫ������
		for(int i=0;i<files.length;i++){
			System.out.println(files[i]);
		}
	}
}
