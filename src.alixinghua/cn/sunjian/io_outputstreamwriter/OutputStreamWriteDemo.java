package cn.sunjian.io_outputstreamwriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

/**
 * OutputStreamWrite����ϰ��д���ֽ������ַ�������ʽ��д��
 * 
 * 		���ֽ���������ַ����������ʽ�����д����
 * 
 * @author jack
 *
 */
public class OutputStreamWriteDemo {

	public static void main(String[] args) throws IOException {

		File file = new File("c:"+File.separator+"text3.txt");//�����ļ�
		
		Writer writer = null;//�����ַ����������
		
		//���ֽ�����Ϊ�ַ���
		writer = new OutputStreamWriter(new FileOutputStream(file));//����ʵ�����������OutputStreamWriter������յ���һ���ֽ�������
	
		String str = "my name is jack!";//����д�������
		
		writer.write(str);//д����
		
		writer.close();//�ر������
		
	}

}
