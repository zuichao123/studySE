package cn.sunjian.io.encode;

import java.io.IOException;

public class EncodeDemo_2 {

	public static void main(String[] args) throws IOException {

		/*
		 * 字符串--> 字节数组：编码
		 * 字符数组-->字符串：解码
		 * 
		 * 你好：GBK：-60 -29 -70 -61 
		 * 		UTF-8：-28 -67 -96 -27 -91 -67 
		 * 
		 * 如果你编码编错了，解不出来。
		 * 如果编对了，有可能有救。
		 * 
		 * 
		 */
		
		String str = "你好";
		//编码
		byte[] buf = str.getBytes("gbk");
		//解码
		String s1 = new String(buf, "iso8859-1");
		
		System.out.println("s1="+s1);
		//编码
		byte[] buf2 = s1.getBytes("iso8859-1");
		//解码
		String s2 = new String(buf2, "GBK");
		
		System.out.println("s2="+s2);
		
		
	}

}
