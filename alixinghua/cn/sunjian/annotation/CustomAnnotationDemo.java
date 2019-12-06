package cn.sunjian.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Annotation��ע��
 * 
 * 		�Զ���Annotation
 * 
 * @author jack
 *
 */
enum MyValue{
	JS,C,JAVA;
}

@Retention(value = RetentionPolicy.RUNTIME)//��ʾ��Annotation������ʱ��Ч
public @interface CustomAnnotationDemo{
	public String value();//����һ��ֵ
	public String twoValue();//���յڶ���ֵ
	public String[] arrValue();//����������һ�����飬��������
	
	public String username() default "sunjian";//ָ��Ĭ��ֵ
	public String password() default "123456";
	
	public MyValue values() default MyValue.JAVA;//��ö����ȡ�̶���ֵ
}

@CustomAnnotationDemo(value = "һ������",twoValue = "��������",arrValue = {"����1","����2","����3"},values = MyValue.JAVA)
class Demo4{
	public String getInfo(){
		return "";
	}
}