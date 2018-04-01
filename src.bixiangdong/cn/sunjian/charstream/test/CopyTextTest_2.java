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
			fr = new FileReader("IO流.txt");
			fw = new FileWriter("I0流_3.txt");
			
			//创建一个临时的容器，用于缓存读取到的字符
			char[] ch = new char[BUFFER_SIZE];
			
			//定义一个变量记录读取到的字符个数
			int num = 0;
			
			//进行读写操作
			while((num = fr.read(ch)) != -1){
				fw.write(ch, 0, num);
			}
			
		} catch (IOException e) {
			throw new RuntimeException("读写失败！");
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
