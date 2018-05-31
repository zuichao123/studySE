package cn.sunjian.io_sequenceinputstream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.SequenceInputStream;

/**
 * java.io�ϲ�������ϰ
 * 
 * 		�������ļ��е����ݺϲ���һ���ļ���
 * 
 * @author sunjian
 *
 */
public class SequenceDemo {

	public static void main(String[] args) throws IOException {

		InputStream input1 = null;//����������1
		InputStream input2 = null;//����������2
		OutputStream ops = null;//���������
		SequenceInputStream sis = null;//����ϲ���
		
		input1 = new FileInputStream(new File("c:"+File.separator+"a.txt"));
		input2 = new FileInputStream(new File("c:"+File.separator+"b.txt"));
		ops = new FileOutputStream(new File("c:"+File.separator+"ab.txt"));
		sis = new SequenceInputStream(input1, input2);
		
		int temp = 0;//��Ŷ�ȡ�����ݣ��������ж��Ƿ�����˽�β-1��
		
		while((temp = sis.read()) != -1){//ѭ�����
			ops.write(temp);//д������
		}
		
		input1.close();
		input2.close();
		ops.close();
		sis.close();
	}

}
