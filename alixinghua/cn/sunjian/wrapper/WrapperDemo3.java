package cn.sunjian.wrapper;
/**
 * ��װ��
 * 
 * ��һ����������ɵ��ַ�����ת��int/float��������
 * 
 * @author sunjian
 *
 */
public class WrapperDemo3 {

	public static void main(String[] args) {
	
		String str = "123456";
		String str2 = "123.456";
		
		int x = Integer.parseInt(str);
		float y = Float.parseFloat(str2);
		
		System.out.println(x);
		System.out.println(y);
		
	}

}
