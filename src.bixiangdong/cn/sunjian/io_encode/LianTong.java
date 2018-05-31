package cn.sunjian.io_encode;

import java.io.IOException;

public class LianTong {

	public static void main(String[] args) throws IOException {

		String str = "联通";
		
		/*
		11000001
		10101010
		11001101
		10101000
		
		与utf-8的解码格式相同了
		
		*/
		
		byte[] buf = str.getBytes("gbk");
		
		for(byte b:buf){
			System.out.println(Integer.toBinaryString(b&255));
		}
	}

}
