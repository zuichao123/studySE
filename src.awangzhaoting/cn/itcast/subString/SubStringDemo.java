package cn.itcast.subString;

public class SubStringDemo {
	
	public static void main(String[] args) {
		String str = "C:\\Users\\sunjian\\desktop\\a.txt";
		String str2 = "b.txt";

		System.out.println(str.substring(str.lastIndexOf("\\")));//�������һ����\\���Ժ�������ַ���������\\��
		System.out.println(str.substring(str.lastIndexOf("\\")+1));//�������һ����\\���Ժ�������ַ�����������\\��
		System.out.println(str2.substring(str2.lastIndexOf("\\")+1));//���ص�0���ַ�
		
		
		System.out.println(str.substring(str.indexOf("\\")));
		System.out.println(str.substring(3));
	}

}
