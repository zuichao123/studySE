package cn.sunjian.io_outputstream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 
 * java.io��ϰ��
 * 
 * 		OutputStream����ϰ���ֽ��������д��
 * 
 * 			���ļ���ĩβ׷�����ݣ�
 * 			����׷������ʱ�����У�\r\n
 * 			����ѭ����ʽд�룺
 * 
 * @author jack
 *
 */
public class OutputStreamDemo2 {

	public static void main(String[] args) throws IOException {

		//1.ʹ��File���ҵ�һ���ļ�
		File file = new File("c:"+File.separator+"text2.txt");
		
		//2.ͨ������ʵ�����������
		OutputStream out = null;//׼��һ���������
		
		out = new FileOutputStream(file,true);//����ʵ�����������[��ʾ���ļ���ĩβ׷������]
		
		//3.���ж�д����(��ΪOutputStream��ֻ��д��byte��so������)
		String str = "\r\nmy name is jack!";//�������������
		byte [] b = str.getBytes();//���ַ���ת��byte����
		
		for(int i=0;i<b.length;i++){
			out.write(b[i]);//ÿ��ֻд��һ��
		}
		
		/*
		 * ���ϵĲ����У���д������֮���ļ�֮ǰ�������Ѿ��������ˣ�
		 * ��Ϊ��IO������Ĭ�ϵ�����ǽ�����и��ǵģ���ô�������Ҫ��ִ��׷�ӵĹ��ܣ�
		 * ���������׷�ӵĲ������ҵ�FileOutputStream�ࡣ
		 */
		
		//4.�ر������
		out.close();
		
	}

}
