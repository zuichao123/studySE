package cn.sunjian.io_encode;

import java.io.IOException;

public class LianTong {

	public static void main(String[] args) throws IOException {

		String str = "��ͨ";
		
		/*
		11000001
		10101010
		11001101
		10101000
		
		��utf-8�Ľ����ʽ��ͬ��
		
		*/
		
		byte[] buf = str.getBytes("gbk");
		
		for(byte b:buf){
			System.out.println(Integer.toBinaryString(b&255));
		}
	}

}
