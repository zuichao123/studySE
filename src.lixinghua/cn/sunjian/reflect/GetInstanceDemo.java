package cn.sunjian.reflect;

/**
 * java������ƣ�
 * 
 * 		ȡ����Ľṹ��
 * 			ȡ����ʵ�ֵ�ȫ���ӿڣ�
 * 
 * @author jack
 *
 */
public class GetInstanceDemo {

	public static void main(String[] args) {
	
		Class<?> c = null;//����Class����
		
		try {
			c = Class.forName("cn.sunjian.reflect.Person3");//ʵ��������
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Class<?> c1[] = c.getInterfaces();//��������ʽ����ʵ�ֵ�ȫ���ӿڣ�
		for(int i=0;i<c1.length;i++){
			System.out.println("ʵ�ֵĽӿ����ƣ�"+c1[i].getName());//���
		}
		
	}

}
