package cn.sunjian.annotation_target;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * ����Annotation��
 * 
 * 		@Targetע�ͣ�ָ��Annotationʹ�õķ�Χ
 * 
 * 		ͨ��java�������ȡ��Annotation��
 * 			ȫ���ģ�
 * 			ָ���ģ�
 * 
 * @author jack
 *
 */
public class TargetAnnotationDemo {

	public static void main(String[] args) {
		
		Class<?> c = null;
		
		try {
			c = Class.forName("cn.sunjian.annotation_thorough.SimpleBeanDemo");//ʵ����Class�����
			Method me = c.getMethod("toString");//�ҵ�toString()����

			//ȡ�÷����ϵ�ȫ����Annotation
			Annotation an[] = me.getAnnotations();
			//���Annotation
			for(Annotation a : an){
				System.out.println(a);
			}
			
			//ȡ��ָ����Annotation
			if (me.isAnnotationPresent(MyTargetAnnotation.class)) {//�жϷ������Ƿ��Ǵ���Annotation
				MyTargetAnnotation mta = null;
				mta = me.getAnnotation(MyTargetAnnotation.class);//�õ�ָ����annotation
			
				String key = mta.key();
				String value = mta.value();
				System.out.println("\n"+key+","+value);
			}else {
				System.out.println("û��annotation");	
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
