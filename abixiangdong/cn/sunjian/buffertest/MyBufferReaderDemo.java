package cn.sunjian.buffertest;

import java.io.FileReader;
import java.io.IOException;

public class MyBufferReaderDemo {

	public static void main(String[] args) throws IOException {
		
		FileReader br = new FileReader("buf.txt");
		
		//Ϊ����߶�ȡ��Ч�ʣ�ʹ�����ַ����Ļ�����
		MyBufferedReader bufr = new MyBufferedReader(br);
		
		String line = null;
		
		while((line = bufr.myReadLine()) != null){
			System.out.println(line.toString());
		}
		
		bufr.myClose();
	}

}
