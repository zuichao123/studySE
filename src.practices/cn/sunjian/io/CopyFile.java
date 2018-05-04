package cn.sunjian.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * java.io������ϰ��
 * 
 * 		copyԴ�ļ�    ��    Ŀ���ļ�
 * 
 * 	˼·��
 * 		����������ϵĸ�ʽ����϶�Ҫʹ�ó�ʼ����������ʽ����������·�������ԣ���ʱ�ͱ������������ĸ���������֤���ж����Ƿ�Ϊ2��
 * 		ʹ���ֽ�������Ϊ�������������һ��ͼƬ��
 * 		�����ַ�ʽ���Բ��ã�
 * 			1.��Դ�ļ��е�����ȫ����ȡ������֮��һ����д�뵽Ŀ���ļ��У�
 * 			2���߶���д�ķ�ʽ��	
 * 
 * @author jack
 *
 */
public class CopyFile {

	public static void main(String[] args) {

		if (args.length != 2) {
			System.out.println("����Ĳ�������ȷ��");
			System.out.println("���磺java CopyFile Դ�ļ�    Ŀ���ļ�");
			System.exit(1);//ϵͳ�˳�
		}
		
		File f1 = new File(args[0]);//ʵ����Դ�ļ�����
		File f2 = new File(args[1]);//ʵ����Ŀ���ļ�����
		
		if (!f1.exists()) {//���Ŀ���ļ�������
			System.out.println("Դ�ļ�������");
			System.exit(1);//ϵͳ�˳�
		}
		
		InputStream input = null;//�����ֽ�����������ȡ������
		OutputStream out = null;//�����ֽ��������д�룩����
		
		try {			
			input = new FileInputStream(f1);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {			
			out = new FileOutputStream(f2);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		if (input != null && out != null) {//�ж������������Ƿ�׼������
			int temp = 0;//��Ŷ�ȡ���ݣ��ж��ļ��Ƿ�������
			try {				
				while((temp = input.read()) != -1){
					out.write(temp);
				}
				System.out.println("������ɣ�");
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("����ʧ�ܣ�");
			}
		}
		
		try {
			input.close();//�ر�������
			out.close();//�ر������
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}















