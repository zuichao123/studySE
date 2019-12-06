package cn.sunjian.io_filewrite;

import java.io.FileWriter;
import java.io.IOException;

public class IOExceptionDemo {

	private static final String LINE_SEPARATOR = System.getProperty("line.separator");

	public static void main(String[] args) {
		
		
		FileWriter fw=null;
		try {
			fw = new FileWriter("F:\\demo.txt",true);
			fw.write("ÀÔΩ°"+LINE_SEPARATOR+"ÀÔΩ°");
		} catch (IOException e) {
			System.out.println(e.toString());
		}finally {
			if(fw!=null)
				try {
					fw.flush();
					fw.close();
				} catch (IOException e) {
					System.out.println("πÿ±’ ß∞‹£°");
				}
		}
	
		
		
	}

}
