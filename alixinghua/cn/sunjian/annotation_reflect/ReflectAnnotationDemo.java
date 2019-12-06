package cn.sunjian.annotation_reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * ������Annotation��
 * 
 * 		ͨ��java�������ȡ��Annotation��
 * 			ȫ���ģ�
 * 			ָ���ģ�
 * 
 * @author jack
 *
 */
public class ReflectAnnotationDemo {

	public static void main(String[] args) {
		
		Class<?> c = null;
		
		try {
			c = Class.forName("cn.sunjian.annotation_reflect.SimpleBeanDemo");//ʵ����Class�����
			Method me = c.getMethod("toString");//�ҵ�toString()����

			//ȡ��ȫ����Annotation
			Annotation an[] = me.getAnnotations();
			//���Annotation
			for(Annotation a : an){
				System.out.println(a);
			}
			
			//ȡ��ָ����Annotation
			if (me.isAnnotationPresent(MyDefaultAnnotationReflect.class)) {//�ж��Ƿ���ָ����Annotation
				MyDefaultAnnotationReflect mda = null;
				mda = me.getAnnotation(MyDefaultAnnotationReflect.class);//�õ�ָ����annotation
			
				String key = mda.key();
				String value = mda.value();
				System.out.println("\n"+key+","+value);
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		
		
	}
}
