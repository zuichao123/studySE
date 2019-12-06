package cn.sunjian.annotation_Inherited;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * ����Annotation��
 * 
 * 		@Inheritedע�ͣ���ʾ���Ա��̳�������
 * 			����һ�����࣬�ڸ�����ʹ�ô�Annotation��
 * 
 * @author jack
 *
 */
@Documented
@Inherited
@Retention(value = RetentionPolicy.RUNTIME)
public @interface MyInheritedAnnotation {

	public String name();
}

@MyInheritedAnnotation(name = "�｡")
class Person{//����
	
}

class Student extends Person{//����
	
}

