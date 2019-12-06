package cn.sunjian.io_encode;

/*
��java�У��ַ�����abcd�����ַ�����ab��á��ĳ�����һ���ģ������ĸ��ַ���
����Ӱ���ֽ�����ͬ��һ������ռ�����ֽڡ�
����һ�����������������ֽ�����ȡ�ִ���
�磺���ڡ�ab��á������ȡ�����ֽڣ���ô�ִ�����ab�롰�㡱�ֵİ����
��ô�����Ҫ���������ȥ�ĸ��ֽھ��ǡ�ab�㡱��ȡ����ֽڻ��ǡ�ab�㡱��
*/

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class Test {

	public static void main(String[] args) throws IOException {

		String str = "ab���cdлл";
//		str = "ab�Ʒ�cd�Ʒ�";
		
		gbk_format(str);
		
		System.out.println("########################");
		
		utf8_fomat(str);
		
		
	}
	
	/**
	 * utf-8 ��ʽ�Ľ�ȡ
	 * 
	 * @param str
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 */

	private static void utf8_fomat(String str) throws UnsupportedEncodingException, IOException {
		int len = str.getBytes("utf-8").length;
		
		for(int x=0; x<len;x++){
			System.out.println("��ȡ"+(x+1)+"���ֽڽ���ǣ�"+cutStringByU8Byte(str, x+1));
		}
	}

	public static String cutStringByU8Byte(String str, int len) throws IOException {
		
		//����
		byte[] buf = str.getBytes("utf-8");
		//�������count��¼������ַ����ĳ���
		int count = 0;
		//������ȴ���0��¼һ�Σ��Ϳ��Լ�¼���������byte�������ַ��ĳ���
		for(int x=len-1;x>=0;x--){
			if(buf[x]<0)
				count++;
			else 
				break;
		}
		//����ַ��������������������еĽ����ַ�
		if(count%3==0)
			return new String(buf, 0, len,"utf-8");
		//����ַ��������������������һ�������ȫ�����뷵��
		else if(count%3==1)
			return new String(buf, 0, len-1,"utf-8");
		else
			return new String(buf, 0, len-2,"utf-8");

	}

	/**
	 * gbk ��ʽ�Ľ�ȡ
	 * 
	 * @param str
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 */
	
	private static void gbk_format(String str) throws UnsupportedEncodingException, IOException {
		int len = str.getBytes("gbk").length;
		
		for(int x=0; x<len;x++){
			System.out.println("��ȡ"+(x+1)+"���ֽڽ���ǣ�"+cutStringByByte(str, x+1));
		}
	}
	
	public static String cutStringByByte(String str, int len) throws IOException{
		
		//����
		byte[] buf = str.getBytes("gbk");
		//�������count��¼������ַ����ĳ���
		int count = 0;
		//������ȴ���0��¼һ�Σ��Ϳ��Լ�¼���������byte�������ַ��ĳ���
		for(int x=len-1;x>=0;x--){
			if(buf[x]<0)
				count++;
			else 
				break;
		}
		//����ַ��������������������еĽ����ַ�
		if(count%2==0)
			return new String(buf, 0, len,"gbk");
		//����ַ��������������������һ�������ȫ�����뷵��
		else
			return new String(buf, 0, len-1,"gbk");
			
	}
	
}
