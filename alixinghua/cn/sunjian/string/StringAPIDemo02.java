package cn.sunjian.string;

/**
 * �ַ�����byte�����ת��
 * 
 * ����һЩ��������
 */
public class StringAPIDemo02 {

	public static void main(String[] args) {
		String str1 = "   hello world!    ";
		String str = "HELLO WORLD!";
		String str2 = "hello world!";
		
		byte[] b = str1.getBytes();//�ַ�����Ϊ�ֽ�����
		
		System.out.println(new String(b));//��ȫ�����ֽ������Ϊ�ַ���
		
		System.out.println(new String(b, 1, 3));//�������ֽ������Ϊ�ַ���
		
		System.out.println(str1.length());//ȡ���ַ����ĳ���
	
		System.out.println(str1.indexOf("w"));//�����ַ����ַ����е�λ��
		
		System.out.println(str1.indexOf("o",5));//���ַ����еĵ����λ�ô���ʼ����o���ֵ�λ��
		
		System.out.println(str1.indexOf("x"));//ô�в鵽�Ƿ���-1
	
		System.out.println(str1.trim());//ȥ���������˵Ŀո�����
	
		System.out.println(str1.substring(6));//�ӵ�7��λ�ÿ�ʼ��ȡ���
		
		System.out.println(str1.substring(6, 10));//��ȡ��6��10��λ�õ�����
	
		System.out.println(str1.toUpperCase());//���ַ���ת�ɴ�д���
		
		System.out.println(str.toLowerCase());//���ַ���ת��Сд���
		
		//���ո���ַ������в��,�����
		String s[] = str1.split(" ");
		for(int i=0;i<s.length;i++){
			System.out.println(s[i]);
		}
	
		//�ж��ַ����Ƿ���ָ�����ַ���ͷ�ͽ�β
		if(str.startsWith("*")){
			System.out.println(str);
		}
		if(str.endsWith("*")){
			System.out.println(str);
		}
		
		//�ж��ַ��������Ƿ���ͬ
		System.out.println(str.equals(str2));//���ִ�Сд
		System.out.println(str.equalsIgnoreCase(str2));//�����ִ�Сд
	
		//�ַ����滻����
		System.out.println(str2.replaceAll("l", "x"));
		
	}
}
