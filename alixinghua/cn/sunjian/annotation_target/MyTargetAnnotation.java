package cn.sunjian.annotation_target;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 深入Annotation：
 * 
 * 		@Target注释：指定Annotation使用的范围
 * 
 * @author jack
 *
 */
@Retention(value = RetentionPolicy.RUNTIME)//运行时也有效
@Target({ElementType.TYPE,ElementType.METHOD})//此注释只能用在类上和方法上
public @interface MyTargetAnnotation {

	public String key() default "在自定义的annotation中默认的";
	public String value() default "@Target Element.Type,Element.METHOD";
}
