package cn.sunjian.string;

/**
 * �ַ������ַ������ת��
 * 
 * @author sunjian
 *
 */

public class StringAPIDemo01 {
	public static void main(String[] args) {
		String str = "hello";
		
		char[] c = str.toCharArray();//���ַ���ת���ַ�������
		
		for(int i=0;i<c.length;i++){
			System.out.print(c[i]+"��");
		}
		System.out.println();
		
		String str1 = new String(c);//��ȫ���ַ������飬����ַ���
		String str2 = new String(c, 0, 2);//�������ַ����飬����ַ���
		
		System.out.println(str1);
		
		System.out.println(str2);
		
		System.out.println(str.charAt(3));//ȡ��ָ��λ�õ��ַ���
	}

}
