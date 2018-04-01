package cn.sunjian.charstream.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferReaderDemo {

	public static void main(String[] args) throws IOException {
		
		FileReader br = new FileReader("buf.txt");
		
		//为了提高读取的效率，使用了字符流的缓冲区
		BufferedReader bufr = new BufferedReader(br);
		
		String line = null;
		
		while((line = bufr.readLine()) != null){
			System.out.println(line);
		}
	}

}
