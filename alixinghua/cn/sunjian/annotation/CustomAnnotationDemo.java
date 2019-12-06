package cn.sunjian.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Annotation：注释
 * 
 * 		自定义Annotation
 * 
 * @author jack
 *
 */
enum MyValue{
	JS,C,JAVA;
}

@Retention(value = RetentionPolicy.RUNTIME)//表示此Annotation在运行时有效
public @interface CustomAnnotationDemo{
	public String value();//接收一个值
	public String twoValue();//接收第二个值
	public String[] arrValue();//接收内容是一个数组，传递数组
	
	public String username() default "sunjian";//指定默认值
	public String password() default "123456";
	
	public MyValue values() default MyValue.JAVA;//从枚举中取固定的值
}

@CustomAnnotationDemo(value = "一个参数",twoValue = "两个参数",arrValue = {"数组1","数组2","数组3"},values = MyValue.JAVA)
class Demo4{
	public String getInfo(){
		return "";
	}
}