package cn.sunjian.io.inputstreamwriter;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * InputStreamReader����ϰ������ʹ���ַ�����ȡ�ֽ��������ݣ�
 * 
 * 		ʹ���ַ����������루��ȡ���ֽ�������������
 * 
 * @author jack
 *
 */
public class InputStreamReaderDemo {

	public static void main(String[] args) throws IOException {

		File file = new File("c:"+File.separator+"text2.txt");//�����ļ�
		
		Reader reader = null;//�����ַ�����������
		
		//���ֽ�����Ϊ�ַ���
		reader = new InputStreamReader(new FileInputStream(file));//����ʵ�����������InputStreamReader���յ���һ���ֽ���
	
		char[] c = new char[1024];
	
		int temp = 0;
		int len = 0;
		
		while((temp = reader.read()) != -1){
			c[len] = (char)temp;
			len++;
		}
		
		System.out.println("���ݣ�"+new String(c,0,len));
		
		reader.close();
	}

}
