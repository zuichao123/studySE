package cn.sunjian.annotation_reflect;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 反射与Annotation：
 * 
 * 		自定义一个Annotation；
 * 
 * @author jack
 *
 */

@Retention(value = RetentionPolicy.RUNTIME)//此Annotation在类执行的时候依然有效
public @interface MyDefaultAnnotationReflect {

	public String key() default "sunjian";
	public String value() default "123456";
}
