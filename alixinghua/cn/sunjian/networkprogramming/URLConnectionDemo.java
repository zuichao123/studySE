package cn.sunjian.networkprogramming;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

/**
 * java�����̣�
 * 
 * 		URLConnection�ࣺ
 * 
 * @author jack
 *
 */
public class URLConnectionDemo {

	public static void main(String[] args) throws IOException {

		URL url = new URL("http://www.mldnjava.cn");
		
		URLConnection urlCon = url.openConnection();//��������
		
		System.out.println("���ݴ�С��"+urlCon.getContentLength());
		System.out.println("�������ͣ�"+urlCon.getContentType());
		
	}

}
