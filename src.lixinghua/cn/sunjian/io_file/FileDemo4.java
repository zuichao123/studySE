package cn.sunjian.io_file;

import java.io.File;

/**
 * java_IO��ϰ��
 * 	
 * 		�ж��Ƿ���Ŀ¼��
 * 
 * @author jack
 *
 */
public class FileDemo4 {

	public static void main(String[] args) {

		File file = new File("c:"+File.separator+"users\\jack\\desktop\\2");//ʵ����File�����
		
		if (file.exists()) {			
			if(file.isDirectory()){
				System.out.println(file.getPath()+"����Ŀ¼");
			}else {
				System.out.println(file.getPath()+"������Ŀ¼");
			}
		}else {
			System.out.println("Ŀ�겻���ڣ�");
		}
		
		
	}

}
