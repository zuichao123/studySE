package cn.sunjian.wrapper;
/**
 * ��װ��
 * 
 * װ�䡢���䣺������float
 * 
 * @author sunjian
 *
 */
public class WrapperDemo2 {

	public static void main(String[] args) {
		float x = 3.0f;//������������
		Float f = new Float(x);//װ�䣺�������������ͱ�Ϊ��װ�ࣻ
		@SuppressWarnings("unused")
		float temp = f.floatValue();//���䣺��һ����װ���Ϊ�����������͡�
	}

}
