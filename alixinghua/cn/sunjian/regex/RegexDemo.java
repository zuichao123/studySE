package cn.sunjian.regex;

/**
 * ������ʽ������ϰ��
 * 
 * 		�ж�һ���ַ����Ƿ����������
 * 
 * 			ԭʼ����
 * 
 * @author jack
 *
 */
public class RegexDemo {

	public static void main(String[] args) {
	
		String str = "12345t67890";
		
		boolean flag = true;//����һ����Ǳ���
		
		
		//�Ƚ��ַ�����ֳ��ַ�������������ж�
		char c[] = str.toCharArray();//���ַ�������ַ�����
		
		for(int i=0;i<c.length;i++){//����ѭ���ж�
			if (c[i]<'0' || c[i]>'9') {
				flag = false;	//�ı���
				break; 		//���ټ���ִ��
			}
		}
		if (flag) {
			System.out.println("����������ɣ�");
		}else {
			System.out.println("������������ɣ�");
		}
	}

}
