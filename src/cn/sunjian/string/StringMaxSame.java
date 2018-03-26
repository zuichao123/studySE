package cn.sunjian.string;

/**
 * �ɂ��ַ����������ͬ���ִ�
 * 
 * ��qwerabcdtyuiop��
 * ��xcabcdvbn��
 * 
 * ˼·��
 * 1.��Ȼȡ��������ִ����ȿ��̵��ǂ��ַ����Ƿ����L���ǂ��ַ�����
 * 	 ������ڣ��̵��ǂ��ַ������Ǵ��ִ�
 * 2.��������أ����N�͌��̵��ǂ��ִ��M���L���f�p�ķ�ʽȥ�ִ���ȥ�L�����Д��Ƿ����
 * 	 ������ھ����ҵ����Ͳ��������ˡ�
 * 
 * @author sunjian
 *
 */

public class StringMaxSame {

	public static void main(String[] args) {

		String s1 = "qwerabcdtyuiop";
		String s2 = "xcabcdvbn";
		
		String s = getMaxSubstring(s1, s2);
		System.out.println("�����ͬ���ִ�="+s);
	}

	public static String getMaxSubstring(String s1, String s2) {
		
		String max = null; 
		String min = null;
		max = (s1.length()>s2.length())?s1:s2;
		min = max.equals(s1)?s2:s1;
		
		System.out.println("max="+max);
		System.out.println("min="+min);
		
		for(int i = 0; i<min.length(); i++){
			
			for(int a = 0, b = min.length()-i; b!=s2.length()+1;  a++,b++){
				
				String sub = min.substring(a, b);
//				System.out.println(sub);
				if (max.contains(sub)) {
					return sub;
				}
			}
		}
		
		return null;
	}

}
