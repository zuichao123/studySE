package cn.sunjian.stringbuilder;

/**
 * ��һ������ת�����ַ���
 * 
 * ˼·��
 * 1.��������������������
 * 2.��ͨ������StringBuilderʵ��
 * 
 * @author sunjian
 *
 */
public class StringBuilderDemo {

	public static void main(String[] args) {
		
		int [] arr = {1,3,4,5,6,7,8,912,234,8,78,13,};
		String s1 = arrayToString(arr);
		System.out.println(s1);
	    String s2 = arrayToString2(arr);
	    System.out.println(s2);
	}

	public static String arrayToString2(int[] arr) {

		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (int i = 0; i < arr.length; i++) {
			if (i<arr.length-1) {				
				sb.append(arr[i]+",");
			}else {
				sb.append(arr[i]+"]");
			}
		}
		return sb.toString();
	}

	public static String arrayToString(int[] arr) {
		String string = "[";
		for (int i = 0; i < arr.length; i++) {
			if (i<arr.length-1) {				
				string += (arr[i]+",");
			}else {
				string += arr[i]+ "]";
			}
		}
		return string;
	}

}
