package cn.sunjian.charstream;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * ��c�̵�һ���ı��ļ����Ƶ�d��
 * 
 * ˼·��
 * 1����Ҫ��ȡԴ��
 * 2����������Դ����д�뵽Ŀ�ĵأ�
 * 3����Ȼ�ǲ����ı����ݣ�ʹ���ַ���
 * 
 * @author sunjian
 *
 */
public class CopyTextTest {

	public static void main(String[] args) throws IOException {
		
		//1,��ȡһ�����е��ı��ļ���ʹ���ַ���ȡ�����ļ������
		FileReader fr = new FileReader("IO��.txt");
		//2,����һ��Ŀ�ģ����ڴ洢��������
		FileWriter fw = new FileWriter("copytext_1.txt");
		//3,Ƶ���Ķ�д����
		int ch = 0;
		while((ch=fr.read())!= -1){
			fw.write(ch);
		}
		//4,�ر���
		fr.close();
		fw.close();
	}

}
