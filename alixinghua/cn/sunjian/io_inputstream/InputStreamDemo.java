package cn.sunjian.io_inputstream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * InputStream�������ϰ���ֽ������������Ƕ�ȡ������
 * 
 * 		��ȡ���ݣ�ֱ��ʹ��byte����ķ�ʽ���
 * 		
 * 			�˷�����
 * 			ֻ�ʺ���֪����������С��ʱ��
 * 			��ʱ���ݶ�ȡ�����ˣ������кܶ�Ŀո�ʹ��read�����������ݵĳ��ȣ��ڸ���String���ָ��λ�ý��ж�ȡ
 *			 �����ļ��Ĵ�С������byte����ռ�
 * 
 * @author jack
 *
 */
public class InputStreamDemo {

	public static void main(String[] args) throws IOException {

		//1.ʹ��File���ҵ�һ���ļ�
		File file = new File("c:"+File.separator+"text2.txt");
		
		//2.ͨ������ʵ�����������
		InputStream in = null;//׼����һ������Ķ���
		in = new FileInputStream(file);//ͨ������Ķ�̬�ԣ�����ʵ����
		
		//3.��ȡ����
		byte b[] = new byte[(int) file.length()];//���е����ݶ���ȡ��byte�����С�����Ĵ�С���ļ���С������
		int len = in.read(b);//��ȡ���ݣ����������ݵĳ���
		
		//��ͷ��ʼ����������β
		System.out.println("���鳤�ȣ�"+len+"\t\n���ݣ�"+new String(b,0,len));//��byte����ת�����ַ������������
		
		//4.�ر�������
		in.close();		
		
	}

}
