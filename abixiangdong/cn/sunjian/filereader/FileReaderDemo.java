package cn.sunjian.filereader;

import java.io.FileReader;
import java.io.IOException;

public class FileReaderDemo {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		
		/**
		 * 
		 */
		
		FileReader fr = null;
		fr = new FileReader(System.getProperty("user.dir")+"/files/bixiangdong/others/demo.txt");
	
	
		char[] buf = new char[12];
		
		int num = 0;
		
		while((num = fr.read(buf)) != -1){
			System.out.println(new String(buf,0,num));//������Ԫ�ش�0�Ǳ굽���������һ���Ǳ��е�Ԫ��ת�����ַ���
		}
		
		
		
	}

}
