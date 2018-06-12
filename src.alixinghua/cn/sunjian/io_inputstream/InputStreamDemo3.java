package cn.sunjian.io_inputstream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * InputStream�������ϰ���ֽ������������Ƕ�ȡ������
 * 
 * 		��ȡ���ݣ�
 * 		
 * 			�����ļ�ĩβ������-1
 * 
 * @author jack
 *
 */
public class InputStreamDemo3 {

	public static void main(String[] args) throws IOException {

		//1.ʹ��File���ҵ�һ���ļ�
		File file = new File("c:"+File.separator+"text2.txt");
		
		//2.ͨ������ʵ�����������
		InputStream in = null;//׼����һ������Ķ���
		in = new FileInputStream(file);//ͨ������Ķ�̬�ԣ�����ʵ����
		
		//3.��ȡ����
		byte b[] = new byte[(int) file.length()];//���е����ݶ���ȡ��byte�����С�����Ĵ�С���ļ���С������
		
		int len = 0;//��¼���鳤��
		int temp = 0;//����ÿһ����ȡ����������
		
		/*
		 * ����֪����ȡ�����ж���ʱ��ʹ�ô˷���
		 */
		while((temp = in.read()) != -1){
			//��ʾ�������ݣ�û�ж���
			b[len] = (byte) temp;
			len++;
		}
		
		//��ͷ��ʼ����������β
		System.out.println("���ݣ�"+new String(b));//��byte����ת�����ַ������������
		
		//4.�ر�������
		in.close();		
		
	}

}
