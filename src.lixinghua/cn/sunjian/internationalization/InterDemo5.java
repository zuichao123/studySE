package cn.sunjian.internationalization;

import java.util.ListResourceBundle;

/**
 * ���ʻ�������ϰ��
 * 		
 * 		java�����ԣ�ʹ��һ���������Դ�ļ�
 * 
 * 
 * @author jack
 *
 */
class Message_zh_CN extends ListResourceBundle{
	private final Object data[][] = {
			{"info","���ģ���ã�{0}��"},
			{"info","Ӣ�ģ�hello"},
			{"info","����,nihao"}
	};
	//��д����
	public Object[][] getContents(){
		return data;
	}
}


public class InterDemo5 {

	public static void main(String[] args) {
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
