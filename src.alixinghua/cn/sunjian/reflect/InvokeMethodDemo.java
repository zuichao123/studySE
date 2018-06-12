package cn.sunjian.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * java������Ƶ������о����ص㸴ϰ��
 * 
 * 		����Person3���е�sayChina()������(�޲�)
 * 		����Person3���е�sayHello()������(�в�)
 * 
 * 		����Person3���е�setter()����
 * 		����Person3���е�getter()����
 * 
 * 		����Person3���е����ԣ�
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
		Object obj = null;
		try {
			obj = c.newInstance();
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
		setter(obj, "name", "�｡", String.class);//����setter����
		setter(obj, "age", 30, int.class);
		
		/*
		 * ����getter()����
		 */
		System.out.print("������ ");
		getter(obj, "name");
		System.out.print("���䣺");
		getter(obj, "age");
		
		/*
		 * �������ԣ���setter��getter�����޹�
		 * 		���ù������ԣ�getField(String name)
		 * 		���ñ������ԣ�getDeclaredField(String name)
		 * 		�������ԣ�set(Object obj,String name)
		 * �ڷ���˽�����Ե�ʱ�򣬱�����������Կɼ���setAccessible(true)
		 */
		Field nameField = null;
		Field ageField = null;
		
		try {
			nameField = c.getDeclaredField("name");//�õ�name����
			ageField = c.getDeclaredField("age");//�õ�age����
			
			nameField.setAccessible(true);//����name���Կɼ�
			ageField.setAccessible(true);//����age���Կɼ�
			
			nameField.set(obj, "�����ʥ");//����name��������
			ageField.set(obj, 500);//����age��������
			System.out.println("������"+nameField.get(obj));
			System.out.println("���䣺"+ageField.get(obj));
		} catch (Exception e) {
			e.printStackTrace();
		}
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
	
	public static void getter(Object obj,String att){//�����������Ͳ���
		try {			
			Method met = obj.getClass().getMethod("get"+initStr(att));//�õ�setter����
			System.out.println(met.invoke(obj));//����getterȡ�����ݺ����
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static String initStr(String old) {//�����ʵ�����ĸ��д
		String str = old.substring(0,1).toUpperCase() + old.substring(1);
		return str;
	}

}
