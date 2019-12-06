package cn.sunjian.io_file;

import java.io.File;

/**
 * java_IO��ϰ��
 * 	
 * 		�г�ָ���ļ��������е����ݣ��������ļ����е�����
 * 
 * 	˼·��
 * 		Ҫ���жϸ�����·���Ƿ���Ŀ¼��֮����ʹ��listFiles()�г�һ��Ŀ¼�е�ȫ�����ݣ�
 * 		һ���ļ����п��ܰ����������ļ������ļ��У����ļ�����Ҳ���ܻ�������������ļ������Դ˴�ֻ�ܲ��õݹ�ĵ��÷�ʽ��ɡ�
 * 
 * 		�������£�	
 * 
 * @author jack
 *
 */
public class FileDemo5 {

	public static void main(String[] args) {

		File file = new File("f:"+File.separator);//ʵ����File�����
		
		print(file);
	}

	private static void print(File file) {//�ݹ���ã��жϵ�ǰ·���Ƿ���Ŀ¼�����ļ�

		if (file != null) {//�������Ϊ��
			if (file.isDirectory()) {//���������Ŀ¼
				File files[] = file.listFiles();//�г����Ե�����·��
				if (files != null) {//������ݲ�Ϊ��ʱ�������					
					for(int i=0;i<files.length;i++){
						print(files[i]);//�����ݹ�����ж��г�������
					}
				}
			}else {
				System.out.println(file);//�����ǰ�ļ�·��
			}
		}
	}

}
