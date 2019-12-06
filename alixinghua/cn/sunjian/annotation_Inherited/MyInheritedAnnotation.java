package cn.sunjian.annotation_Inherited;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 深入Annotation：
 * 
 * 		@Inherited注释：表示可以被继承下来。
 * 			定义一个父类，在父类上使用此Annotation；
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

@MyInheritedAnnotation(name = "孙健")
class Person{//父类
	
}

class Student extends Person{//子类
	
}

