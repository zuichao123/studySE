package cn.sunjian.annotation_target;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * 深入Annotation：
 * 
 * 		@Target注释：指定Annotation使用的范围
 * 
 * 		通过java反射机制取得Annotation：
 * 			全部的；
 * 			指定的；
 * 
 * @author jack
 *
 */
public class TargetAnnotationDemo {

	public static void main(String[] args) {
		
		Class<?> c = null;
		
		try {
			c = Class.forName("cn.sunjian.annotation_thorough.SimpleBeanDemo");//实例化Class类对象
			Method me = c.getMethod("toString");//找到toString()方法

			//取得方法上的全部的Annotation
			Annotation an[] = me.getAnnotations();
			//输出Annotation
			for(Annotation a : an){
				System.out.println(a);
			}
			
			//取得指定的Annotation
			if (me.isAnnotationPresent(MyTargetAnnotation.class)) {//判断方法上是否是存在Annotation
				MyTargetAnnotation mta = null;
				mta = me.getAnnotation(MyTargetAnnotation.class);//得到指定的annotation
			
				String key = mta.key();
				String value = mta.value();
				System.out.println("\n"+key+","+value);
			}else {
				System.out.println("没有annotation");	
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
