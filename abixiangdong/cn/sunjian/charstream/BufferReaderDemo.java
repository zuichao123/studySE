package cn.sunjian.charstream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferReaderDemo {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		
		FileReader br = new FileReader("buf.txt");
		
		//Ϊ����߶�ȡ��Ч�ʣ�ʹ�����ַ����Ļ�����
		BufferedReader bufr = new BufferedReader(br);
		
		String line = null;
		
		while((line = bufr.readLine()) != null){
			System.out.println(line);
		}
	}

}
