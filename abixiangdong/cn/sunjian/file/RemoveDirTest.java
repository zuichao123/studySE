package cn.sunjian.file;

/**
 * ɾ��ָ��������Ŀ¼
 * 	ɾ��ʱ���ȱ�����Ŀ¼�е��ļ���������ļ���ɾ���ļ�����ɾ��Ŀ¼
 */

import java.io.File;

public class RemoveDirTest {

	public static void main(String[] args) {

		/**
		 * ɾ��һ�������ݵ�Ŀ¼
		 * ԭ��������������ɾ
		 * ��Ҫ������ȱ���
		 */
		
		File dir = new File("f:\\�½��ļ��� - ����");//ָ��Ŀ¼
		
		removeDir(dir);
		
	}

	public static void removeDir(File dir) {

		File[] files = dir.listFiles();
		
		for(File file :files){
			
			if(file.isDirectory()){//����ɾ���ļ�
				removeDir(file);
			}else {
				System.out.println(file+":"+file.delete());
			}
		}
		//ɾ��Ŀ¼
		System.out.println(dir+":"+dir.delete());
	}	

}
