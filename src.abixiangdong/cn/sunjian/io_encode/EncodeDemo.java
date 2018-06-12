package cn.sunjian.io_encode;

import java.io.IOException;

/**
 * 编码表
 * 
 * @author sunjian
 *
 */
public class EncodeDemo {

	public static void main(String[] args) throws IOException {

		/*
		 * 字符串--> 字节数组：编码
		 * 字符数组-->字符串：解码
		 * 
		 * 你好：GBK：-60 -29 -70 -61 
		 * 		UTF-8：-28 -67 -96 -27 -91 -67 
		 * 
		 * 如果你编码编错了，解不出来。
		 * 
		 * 
		 */
		
		String str = "你好";

		//编码
//		byte[] buf = str.getBytes("GBK");
		byte[] buf = str.getBytes("utf-8");
		
		//解码
//		String s1 = new String(buf, "GBK");
		String s1 = new String(buf, "utf-8");		
		
		printBytes(buf);
		
		System.out.println(s1);
	}

	public static void printBytes(byte[] buf) {
		
		for(byte b:buf){
			System.out.print(b+" ");
		}
		
		
	}

}
