package cn.sunjian.io_filewriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * �ַ������������ϰ��
 * 
 * 		FileWriter��
 * 
 * @author jack
 *
 */
public class FileWriterDemo {

	public static void main(String[] args) throws IOException {

		File file = new File("c:"+File.separator+"text.txt");//����File�����ָ���ļ���λ��
		
		Writer writer = null;//�����ֽ�������Ķ���
		
		writer = new FileWriter(file,true);//����ʵ�����������;����׷��
		
		String str = "I love you xiaoyanjing\r\n";//����д�������
		writer.write(str);//д������

		writer.close();//�ر��ַ������
	}

}
