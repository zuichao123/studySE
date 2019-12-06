package cn.sunjian.annotation_reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * 反射与Annotation：
 * 
 * 		通过java反射机制取得Annotation：
 * 			全部的；
 * 			指定的；
 * 
 * @author jack
 *
 */
public class ReflectAnnotationDemo {

	public static void main(String[] args) {
		
		Class<?> c = null;
		
		try {
			c = Class.forName("cn.sunjian.annotation_reflect.SimpleBeanDemo");//实例化Class类对象
			Method me = c.getMethod("toString");//找到toString()方法

			//取得全部的Annotation
			Annotation an[] = me.getAnnotations();
			//输出Annotation
			for(Annotation a : an){
				System.out.println(a);
			}
			
			//取得指定的Annotation
			if (me.isAnnotationPresent(MyDefaultAnnotationReflect.class)) {//判断是否是指定的Annotation
				MyDefaultAnnotationReflect mda = null;
				mda = me.getAnnotation(MyDefaultAnnotationReflect.class);//得到指定的annotation
			
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
