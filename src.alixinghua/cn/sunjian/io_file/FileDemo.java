package cn.sunjian.io_file;

import java.io.File;
import java.io.IOException;

/**
 * java_IO��ϰ��
 * 	
 * 		��ϰ����ʵ����
			1.����һ�����ļ���
			2.ɾ��һ��ָ�����ļ���
			3.�ۺϴ�����ɾ���ļ��Ĳ�����
			4.����һ���ļ��У�
			5.�г�ָ��Ŀ¼��ȫ���ļ���
			6.�ж�һ��������·���Ƿ���Ŀ¼��
 * 
 * 			File.separator����ʾ��ǰϵͳ��·���ָ���
 * 
 * @author jack
 *
 */
public class FileDemo {

	public static void main(String[] args) {

		File file = new File("c:"+File.separator+"users\\jack\\desktop\\2.txt");//ʵ����File�����
		
		createFile(file);//�����ļ�
		
		deleteFile(file);//ɾ���ļ�
		
		createAndDelete(file);//�ۺϴ�����ɾ���ļ�����
		
	}

	
	
	private static void createAndDelete(File file) {

		if (file.exists()) {//����ļ��Ѿ����ڣ���ɾ��
			file.delete();
		}else {
			try {
				file.createNewFile();//��������ھʹ����ļ�
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}



	private static void deleteFile(File file) {
		if (file.exists()) {//�ж��ļ�������ھ�ɾ��			
			file.delete();
		}
	}

	private static void createFile(File file) {
		try {
			file.createNewFile();//�����ļ�
		} catch (IOException e) {
			e.printStackTrace();//����쳣
		}
	}

}
