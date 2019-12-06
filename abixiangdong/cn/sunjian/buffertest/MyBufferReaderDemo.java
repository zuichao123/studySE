package cn.sunjian.buffertest;

import java.io.FileReader;
import java.io.IOException;

public class MyBufferReaderDemo {

	public static void main(String[] args) throws IOException {
		
		FileReader br = new FileReader("buf.txt");
		
		//为了提高读取的效率，使用了字符流的缓冲区
		MyBufferedReader bufr = new MyBufferedReader(br);
		
		String line = null;
		
		while((line = bufr.myReadLine()) != null){
			System.out.println(line.toString());
		}
		
		bufr.myClose();
	}

}
