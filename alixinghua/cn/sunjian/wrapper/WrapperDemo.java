package cn.sunjian.wrapper;
/**
 * ��װ��
 * 
 * װ�䡢���䣺����
 * 
 * @author sunjian
 *
 */
public class WrapperDemo {

	public static void main(String[] args) {
		int x = 30;//������������
		Integer i = new Integer(x);//װ�䣺�������������ͱ�Ϊ��װ�ࣻ
		@SuppressWarnings("unused")
		int temp = i.intValue();//���䣺��һ����װ���Ϊ�����������͡�
	}

}
