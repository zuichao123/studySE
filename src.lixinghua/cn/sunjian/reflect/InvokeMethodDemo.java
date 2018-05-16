package cn.sunjian.reflect;

import java.lang.reflect.Method;

/**
 * java������Ƶ������о���
 * 
 * 		����Person3���е�sayChina()������(�޲�)
 * 		����Person3���е�sayHello()������(�в�)
 * 
 * 		����Person3���е�setter()����
 * 		����Person3���е�getter()����
 * 
 * @author jack
 *
 */
public class InvokeMethodDemo {

	public static void main(String[] args) {

		Class<?> c = null;//����Class�����
		
		try {
			c = Class.forName("cn.sunjian.reflect.Person3");//ʵ����Class�����
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/*
		 * �����޲η���
		 */
		try {
			Method m1 = c.getMethod("sayChina");//�ҵ�sayChina()����
			m1.invoke(c.newInstance());//���÷������޲εģ�
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/*
		 * ������ڵ��õķ����д����˲�������������ò��������ͼ����ݣ�
		 */
		try {
			Method m2 = c.getMethod("sayHello", String.class,int.class);//�ҵ�sayHello()����
			String rv = null;
			
			rv = (String) m2.invoke(c.newInstance(), "sunjian",30);
			System.out.println(rv);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/*
		 * ����setter()����
		 */
		Object obj = null;
		try {
			obj = c.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		setter(obj, "name", "�｡", String.class);//����setter����
		setter(obj, "age", 30, int.class);
	}

	/*
	 * Object obj:Ҫ�����Ķ���
	 * String att:Ҫ����������
	 * Object value��Ҫ���õ���������
	 * Class<?> type:Ҫ���õ���������
	 */
	public static void setter(Object obj,String att,Object value,Class<?> type){
		try {			
			Method met = obj.getClass().getMethod("set"+initStr(att),type);//�õ�setter����
			met.invoke(obj, value);//����setter������
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private static String initStr(String old) {//�����ʵ�����ĸ��д
		String str = old.substring(0,1).toUpperCase() + old.substring(1);
		return str;
	}

}
