package cn.sunjian.annotation_Inherited;

import java.lang.annotation.Annotation;

/**
 * 深入Annotation：
 * 
 * 		@Inherited注释：表示可以被继承下来。
 * 			定义一个父类，在父类上使用此Annotation；
 * 			取得子类中的annotation；
 * 			取得子类中的annotation设置的内容；
 * 
 * @author jack
 *
 */
public class ReflectInheritedAnnotation{
	public static void main(String[] args) {
		
		Class<?> c = null;
		try {
			c = Class.forName("cn.sunjian.annotation_Inherited.Student");
			Annotation[] an = c.getAnnotations();//取得全部的annotation
			
			for(Annotation a : an){//输出annotation
				System.out.println(a);
			}
			
			//继续取得此Annotation设置的内容
			if (c.isAnnotationPresent(MyInheritedAnnotation.class)) {
				MyInheritedAnnotation mia = null;
				mia = c.getAnnotation(MyInheritedAnnotation.class);
				
				String name = mia.name();
				
				System.out.println("此Annotation设置的内容：\nname = "+name);
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
