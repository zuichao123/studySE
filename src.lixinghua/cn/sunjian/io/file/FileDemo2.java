package cn.sunjian.io.file;

import java.io.File;

/**
 * java_IO��ϰ��
 * 	
 * 		����Ŀ¼����
 * 
 * @author jack
 *
 */
public class FileDemo2 {

	public static void main(String[] args) {

		File file = new File("c:"+File.separator+"users\\jack\\desktop\\2");//ʵ����File�����
		
		file.mkdir();//�����ļ���
		
	}

}
