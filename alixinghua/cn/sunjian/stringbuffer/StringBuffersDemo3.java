package cn.sunjian.stringbuffer;

/**
 * StringBuffer��
 * 		���÷�������ϰ
 * 
 * @author jack
 *
 */
public class StringBuffersDemo3 {

	public static void main(String[] args) {
		StringBuffer buf = new StringBuffer();
		
		buf.append("Hello");

//		buf.insert(0, "sunjian");//�ڵ�һ��λ�ô��������
//		
//		buf.insert(buf.length(), "123");//������������
//		
//		buf.reverse();//�ַ�����ת
//		
//		buf.replace(2, 6, "name");//�滻�ַ���
		
		String str = buf.substring(1, 4);//�ַ�����ȡָ����Χ���ַ���
		
		str = buf.delete(0, 1).toString();//ɾ��ָ����Χ�ڵ�����
		
		if (buf.indexOf("hell")==-1) {//����ָ��������
			System.out.println("û�в��⵽ָ��������");
		}else{
			System.out.println("���Բ��ҵ�ָ��������");
		}
		
		System.out.println(str);
	}

}
