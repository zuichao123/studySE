package cn.sunjian.stringbuffer;

/**
 * StringBuffer��
 * 		�ַ������Ӳ���
 * 
 * @author jack
 *
 */
public class StringBuffersDemo {

	public static void main(String[] args) {

		StringBuffer buf = new StringBuffer();//����StringBuffer����
		buf.append("hello");//��StringBuffer���������
		buf.append("world").append("!!!");//������������append����
		buf.append("\n");//���һ��ת���ַ�
		buf.append("���� = ").append(1).append("\n");//�������
		buf.append("�ַ� = ").append('C').append("\n");//����ַ�
		buf.append("���� = ").append(true);//��Ӳ���ֵ
		
		System.out.println(buf);//ֱ��������󣬵���toString()����
		
	}

}
