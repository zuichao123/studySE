package cn.sunjian.networkprogramming;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * java�����̣�
 * 
 * 		URLEncoder��URLDecoder�ࣺ
 * 			�����Ľ��б���ͽ��������
 * 
 * @author jack
 *
 */
public class URLEncoderURLDecoderDemo {

	public static void main(String[] args) {

		String str = "�пƺ��";
		
		try {
			String encod = URLEncoder.encode(str,"utf-8");
			
			System.out.println("����֮��"+encod);
			
			String decod = URLDecoder.decode(encod, "utf-8");
			
			System.out.println("����֮��"+decod);
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
	}

}
