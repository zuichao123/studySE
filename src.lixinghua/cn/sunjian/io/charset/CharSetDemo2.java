package cn.sunjian.io.charset;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * �ַ����룺��ϰ
 * 	
 * 		���ñ����ʽ
 * 
 * @author jack
 *
 */
public class CharSetDemo2 {

	public static void main(String[] args) throws IOException {

		File file = new File("c:"+File.separator+"text.txt");//ʵ����file��
		
		OutputStream out = new FileOutputStream(file);//ʵ���������
		
		byte[] b = "��ã��й���".getBytes("ISO8859-1");
		
		out.write(b);//���棬д���ļ�
		
		out.close();//�ر������
	}

}
