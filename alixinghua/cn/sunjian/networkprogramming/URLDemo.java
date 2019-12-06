package cn.sunjian.networkprogramming;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * java�����̣�
 * 
 * 		URL�ࣺ
 * 
 * @author jack
 *
 */
public class URLDemo {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {

		try {
			URL url = new URL("http","http://www.mldnjava.cn",80,"/curriculum.htm");
			
			InputStream input = url.openStream();//��������
			
			Scanner scan = new Scanner(input);//ʵ����Scanner��
			
			scan.useDelimiter("\n");//���ö�ȡ�ָ���
			
			while(scan.hasNext()){
				System.out.println(scan.next());
			}
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
	}

}
