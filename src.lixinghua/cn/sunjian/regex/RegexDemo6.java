package cn.sunjian.regex;

/**
 * ������ʽ������ϰ��
 * 
 * 		String��������֧��
 * 
 * 			������ʽ
 * 
 * @author jack
 *
 */
public class RegexDemo6 {

	public static void main(String[] args) {
	
		String str = "A15B223C333D44443E55555F".replaceAll("\\d+","_");
		
		boolean temp = "1983-07-27".matches("\\d{4}-\\d{2}-\\d{2}");
		
		String s[] = "A15B223C333D44443E55555F".split("\\d+");
		
		System.out.println("�ַ����滻������"+str);
		
		System.out.println("�ַ�����֤��"+temp);
		
		System.out.print("�ַ�����֣�");
		for(int i=0;i<s.length;i++){
			System.out.print(s[i]+"\t");
		}
				
	}

}
