package cn.sunjian.io.outputstream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 
 * java.io��ϰ��
 * 
 * 		OutputStream����ϰ
 * 
 * @author jack
 *
 */
public class OutputStreamDemo {

	public static void main(String[] args) throws IOException {

		//1.ʹ��File���ҵ�һ���ļ�
		File file = new File("c:"+File.separator+"text.txt");
		
		//2.ͨ������ʵ�����������
		OutputStream out = null;//׼��һ���������
		out = new FileOutputStream(file);//����ʵ�����������
		
		//3.���ж�д����(��ΪOutputStream��ֻ��д��byte��so������)
		String str = "my name is jack!";//�������������
		byte [] b = str.getBytes();//���ַ���ת��byte����
		out.write(b);//д�����ݣ����������
		
		//4.�ر������
		out.close();
		
	}

}
