package cn.sunjian.annotation_documented;

import java.lang.annotation.Documented;

/**
 * ����Annotation��
 * 
 * 		@Documentedע�ͣ����������κε�Annotation��ʹ��
 * 
 * @author jack
 *
 */
@Documented
public @interface MyDocumentedAnnotation {

	public String key() default "@Documented";
	public String value() default "���������κε�Annotation��ʹ��";
}
