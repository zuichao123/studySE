package cn.sunjian.string;
/**
 * ģ�Mһ��trim����һ�µķ�����
 * ȥ���ַ������^�Ŀո�
 * 
 * ˼·��
 * 1.���x�ɂ�׃����
 * 		һ��������^�_ʼ�Д��ַ����ո�Ľǘˣ�����++��
 * 		һ�������β�_ʼ�Д��ַ����ո�Ľǘˣ�����--��
 * 2.�Дൽ���ǿո��ֹ��ȡ�^β֮�g���ַ����ǘ˼��ɡ�
 * 
 * @author sunjian
 *
 */
public class StringTrim {

	public static void main(String[] args) {

		String s = "     ab   c    ";
		
		s = myTrim(s);
		
		System.out.println(s);
	}

	public static String myTrim(String s) {
		
		int start = 0;
		int end = s.length()-1;
		
		while(start<=end && s.charAt(start)==' '){
			start++;
		}
		while(start<=end && s.charAt(end)==' '){
			end--;
		}
		return s.substring(start, end+1);
	}

}
