package cn.sunjian.regex;

/**
 * ������ʽ������ϰ��
 * 
 * 		String��������֧�֣�|��ע��
 * 
 * 			������ʽ
 * 
 * @author jack
 *
 */
public class RegexDemo7 {

	public static void main(String[] args) {
	
		String str = "sunjian:98|jack:99|sun:97|jian:100";
		
		String s[] = str.split("\\|");//ע��|��������ʽ����һ���߼����������ʾ��������ʹ��|�ָ�ʱҪת��
		
		System.out.println("�ַ�����ֺ�");
		for(int i=0;i<s.length;i++){
			String s2[] = s[i].split(":");//�ٸ���:���в��
			System.out.println(s2[0]+"\t"+s2[1]);//����ֺ�������ַ��������
		}
		
	}

}
