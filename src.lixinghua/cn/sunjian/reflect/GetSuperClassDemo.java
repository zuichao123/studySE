package cn.sunjian.reflect;

/**
 * java������ƣ�
 * 
 * 		ȡ����Ľṹ��
 * 			ȡ����ĸ��ࣻ
 * 
 * @author jack
 *
 */
public class GetSuperClassDemo {

	public static void main(String[] args) {
	
		Class<?> c = null;//����Class����
		
		try {
			c = Class.forName("cn.sunjian.reflect.Person3");//ʵ��������
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Class<?> c1 = c.getSuperclass();//ȡ�ø���
		
		System.out.println("�������ƣ�"+c1.getName());
		
	}

}
