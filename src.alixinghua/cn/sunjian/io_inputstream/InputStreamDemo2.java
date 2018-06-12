package cn.sunjian.io_inputstream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * InputStream�������ϰ�������������Ƕ�ȡ������
 * 
 * 		��ȡ���ݣ�ֱ��ʹ��read()�ķ������
 * 		
 * 			�˷�����
 * 			ֻ�ʺ���֪����������С��ʱ��
 *			 �����ļ��Ĵ�С������byte����ռ�
 * 
 * @author jack
 *
 */
public class InputStreamDemo2 {

	public static void main(String[] args) throws IOException {

		//1.ʹ��File���ҵ�һ���ļ�
		File file = new File("c:"+File.separator+"text2.txt");
		
		//2.ͨ������ʵ�����������
		InputStream in = null;//׼����һ������Ķ���
		in = new FileInputStream(file);//ͨ������Ķ�̬�ԣ�����ʵ����
		
		//3.��ȡ����
		byte b[] = new byte[(int) file.length()];//���е����ݶ���ȡ��byte�����С�����Ĵ�С���ļ���С������
		for(int i=0;i<b.length;i++){
			
			b[i] = (byte)in.read();//��ȡ���ݣ�һ��һ���Ķ�
		}
		
		//��ͷ��ʼ����������β
		System.out.println("���ݣ�"+new String(b));//��byte����ת�����ַ������������
		
		//4.�ر�������
		in.close();		
		
	}

}
