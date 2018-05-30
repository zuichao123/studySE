package cn.sunjian.networkprogramming;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * java网络编程：
 * 
 * 		URLEncoder与URLDecoder类：
 * 			对中文进行编码和解码操作；
 * 
 * @author jack
 *
 */
public class URLEncoderURLDecoderDemo {

	public static void main(String[] args) {

		String str = "中科虹霸";
		
		try {
			String encod = URLEncoder.encode(str,"utf-8");
			
			System.out.println("编码之后："+encod);
			
			String decod = URLDecoder.decode(encod, "utf-8");
			
			System.out.println("解码之后："+decod);
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
	}

}
