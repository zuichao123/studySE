package cn.sunjian.io_bytearrayinputoutputstream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * �ڴ��������ByteArrayInputStream��ByteArrayOutputStream
 * 
 * 		��ϰ����һ����д�ַ������Сд�ַ���������ϰ�ڴ������
 * 
 * @author jack
 *
 */
public class ByteArrayDemo {

	public static void main(String[] args) {

		String str = "ABCDEFGHIJKLMN";
		
		System.out.println("���ݣ�"+str);
		
		ByteArrayInputStream bis = null;//�ڴ�������
		ByteArrayOutputStream bos = null;//�ڴ������
		
		bis = new ByteArrayInputStream(str.getBytes());//ʵ�����ڴ�����������
		bos = new ByteArrayOutputStream();//ʵ�����ڴ����������
		
		int temp = 0;//��Ŷ�ȡ��������
		
		while((temp = bis.read())!=-1){
			char c = (char)temp;//����ȡ��������ת��Ϊ�ַ�
			bos.write(Character.toLowerCase(c));//����ȡ�����ݣ�ת����Сд��������ڴ���
		}
		
		String newStr = bos.toString();//ȡ������		
		
		try {
			bis.close();
			bos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("ת��������ݣ�"+newStr);
	}

	/*
	 * ʵ���ϣ�ͨ��ʵ����������Ĳ�ͬ����ɵĹ���Ҳ��ͬ��
	 * ������ļ�����ʹ��Filexxx��
	 * ������ڴ棬��ʹ��ByteArrayxxx.
	 */
}
