package cn.sunjian.string;

/**
 * 
 * @author sunjian
 *
 */
public class StringDemo {

	public static void main(String[] args) {
		
		/*
		 * String ����ص㣺
		 * �ַ�������һ������ʼ���Ͳ��ᱻ�ı�
		 */
		stringDemo1();
		stringDemo2();
	}

	public static void stringDemo2() {
		
		String string = "abc";//����һ���ַ��������ڳ�������
		String string2 = new String("abc");//���������ַ��������ڶ��ڴ���һ��new��һ���ַ�������
		//String���equals������дObject���е�equals������������String���Լ����ж��ַ��������Ƿ���ͬ�����ݡ�
		//��ʵ���ǱȽ��ַ������ݡ�
		System.out.println(string.equals(string2));
	}

	/**
	 * ��ʾString��
	 */
	private static void stringDemo1() {
		String string = "abc";
		String string2 = "abc";
		//string1��string2������String�����͵ı���ָ�����ͬһ����ַ��
		System.out.println(string == string2);
	}

}
