package cn.sunjian.charstream.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferReaderDemo {

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
