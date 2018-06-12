package cn.sunjian.annotation_reflect;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * ������Annotation��
 * 
 * 		�Զ���һ��Annotation��
 * 
 * @author jack
 *
 */

@Retention(value = RetentionPolicy.RUNTIME)//��Annotation����ִ�е�ʱ����Ȼ��Ч
public @interface MyDefaultAnnotationReflect {

	public String key() default "sunjian";
	public String value() default "123456";
}
