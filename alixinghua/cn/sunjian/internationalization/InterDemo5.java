package cn.sunjian.internationalization;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * ���ʻ�������ϰ��
 * 		
 * 		java�����ԣ�ʹ��һ���������Դ�ļ�
 * 
 * 		������Ϊ����
 * 
 * @author jack
 *
 */

public class InterDemo5 {

	public static void main(String[] args) {
		
		Locale zhLoc = new Locale("zh","CN");//��ʾ�й�����
		
		ResourceBundle zhrb = ResourceBundle.getBundle("Message",zhLoc);//�ҵ����ĵ� �����ļ�����Ҫָ�����ĵ�locale����
		
		String str1 = zhrb.getString("info");
		
		System.out.println("���ģ�"+ MessageFormat.format(str1, "�｡ewq"));//��̬�ı�		
		
		print();
	}

	
	
	
	
	private static void print() {
		Message_zh_CN mzc = new Message_zh_CN();
		
		Object[][] arr = mzc.getContents();
		
		for(int x=0;x<arr.length;x++){
			for(int y=0;y<arr.length-1;y++){
				System.out.print(arr[x][y]+"��");
			}
			System.out.println();
		}
	}
}
