package cn.sunjian.reflect;

/**
 * java������ƣ�
 * 
 * 		��ʶclass��
 * 			��ϰʵ����Class�����ķ��������֣�
				1��ͨ��forName()������
				2����.class
				3������.getClass()����
 * 
 * @author jack
 *
 */
class X{
	
}

public class GetClassDemo {

	public static void main(String[] args) {
		
		Class<?> c1 = null;//ָ������
		Class<?> c2 = null;
		Class<?> c3 = null;
		
		try {
			//���²�����ʽ���ڿ�������õ�һ����ʽ
			c1 = Class.forName("cn.sunjian.reflect.X");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		c2 = new X().getClass();//ͨ��Object���еķ���ʵ����
	
		c3 = X.class;//ͨ����.Classʵ����
		
		System.out.println("�����ƣ�"+c1.getName());//�õ��������
		System.out.println("�����ƣ�"+c2.getName());//�õ��������
		System.out.println("�����ƣ�"+c3.getName());//�õ��������
		
		//**********************************
		X x = new X();
		System.out.println(x.getClass().getName());//�õ��������ڵ���
	}

}
