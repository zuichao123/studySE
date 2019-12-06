package cn.sunjian.annotation_documented;

import java.lang.annotation.Documented;

/**
 * 深入Annotation：
 * 
 * 		@Documented注释：可以用在任何的Annotation上使用
 * 
 * @author jack
 *
 */
@Documented
public @interface MyDocumentedAnnotation {

	public String key() default "@Documented";
	public String value() default "可以用在任何的Annotation上使用";
}
