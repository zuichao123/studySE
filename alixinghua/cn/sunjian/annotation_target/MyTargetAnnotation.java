package cn.sunjian.annotation_target;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ����Annotation��
 * 
 * 		@Targetע�ͣ�ָ��Annotationʹ�õķ�Χ
 * 
 * @author jack
 *
 */
@Retention(value = RetentionPolicy.RUNTIME)//����ʱҲ��Ч
@Target({ElementType.TYPE,ElementType.METHOD})//��ע��ֻ���������Ϻͷ�����
public @interface MyTargetAnnotation {

	public String key() default "���Զ����annotation��Ĭ�ϵ�";
	public String value() default "@Target Element.Type,Element.METHOD";
}
