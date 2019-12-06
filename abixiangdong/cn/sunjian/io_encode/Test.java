package cn.sunjian.io_encode;

/*
在java中，字符串“abcd”与字符串“ab你好”的长度是一样的，都是四个字符。
但对影的字节数不同，一个汉字占两个字节。
定义一个方法，按照最大的字节数来取字串；
如：对于“ab你好”，如果取三个字节，那么字串就是ab与“你”字的半个，
那么半个就要舍弃，如果去四个字节就是“ab你”，取五个字节还是“ab你”。
*/

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class Test {

	public static void main(String[] args) throws IOException {

		String str = "ab你好cd谢谢";
//		str = "ab菲菲cd菲菲";
		
		gbk_format(str);
		
		System.out.println("########################");
		
		utf8_fomat(str);
		
		
	}
	
	/**
	 * utf-8 格式的截取
	 * 
	 * @param str
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 */

	private static void utf8_fomat(String str) throws UnsupportedEncodingException, IOException {
		int len = str.getBytes("utf-8").length;
		
		for(int x=0; x<len;x++){
			System.out.println("截取"+(x+1)+"个字节结果是："+cutStringByU8Byte(str, x+1));
		}
	}

	public static String cutStringByU8Byte(String str, int len) throws IOException {
		
		//编码
		byte[] buf = str.getBytes("utf-8");
		//定义变量count记录传入的字符串的长度
		int count = 0;
		//如果长度大于0记录一次，就可以记录下来解码后byte数组中字符的长度
		for(int x=len-1;x>=0;x--){
			if(buf[x]<0)
				count++;
			else 
				break;
		}
		//如果字符个数是整数，返回所有的解码字符
		if(count%3==0)
			return new String(buf, 0, len,"utf-8");
		//如果字符个数是奇数，舍弃最后一个其余的全部解码返回
		else if(count%3==1)
			return new String(buf, 0, len-1,"utf-8");
		else
			return new String(buf, 0, len-2,"utf-8");

	}

	/**
	 * gbk 格式的截取
	 * 
	 * @param str
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 */
	
	private static void gbk_format(String str) throws UnsupportedEncodingException, IOException {
		int len = str.getBytes("gbk").length;
		
		for(int x=0; x<len;x++){
			System.out.println("截取"+(x+1)+"个字节结果是："+cutStringByByte(str, x+1));
		}
	}
	
	public static String cutStringByByte(String str, int len) throws IOException{
		
		//编码
		byte[] buf = str.getBytes("gbk");
		//定义变量count记录传入的字符串的长度
		int count = 0;
		//如果长度大于0记录一次，就可以记录下来解码后byte数组中字符的长度
		for(int x=len-1;x>=0;x--){
			if(buf[x]<0)
				count++;
			else 
				break;
		}
		//如果字符个数是整数，返回所有的解码字符
		if(count%2==0)
			return new String(buf, 0, len,"gbk");
		//如果字符个数是奇数，舍弃最后一个其余的全部解码返回
		else
			return new String(buf, 0, len-1,"gbk");
			
	}
	
}
