package cn.sunjian.charstream.test;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyTextTest_2 {

	private static final int BUFFER_SIZE = 1024;

	public static void main(String[] args) {

		FileReader fr = null;
		FileWriter fw = null;
		
		try {
			fr = new FileReader("IO��.txt");
			fw = new FileWriter("I0��_3.txt");
			
			//����һ����ʱ�����������ڻ����ȡ�����ַ�
			char[] ch = new char[BUFFER_SIZE];
			
			//����һ��������¼��ȡ�����ַ�����
			int num = 0;
			
			//���ж�д����
			while((num = fr.read(ch)) != -1){
				fw.write(ch, 0, num);
			}
			
		} catch (IOException e) {
			throw new RuntimeException("��дʧ�ܣ�");
		}finally {
			if(fr != null)
				try {
					fr.close();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
			if(fw != null)
			try {
				fw.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
	}

}
