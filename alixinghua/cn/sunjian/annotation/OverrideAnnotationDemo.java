package cn.sunjian.annotation;
/**
 * Annotation：注释
 * 
 * 		@Override：检查覆写的正确性
 * 
 * @author jack
 *
 */
class Person{
	public String getInfo(){
		return "这是一个Person类。。。";
	}
}
class Student extends Person{
	@Override//检查覆写方法的正确性
	public String getInfo(){
		return "这是一个Student类...";
	}
}
public class OverrideAnnotationDemo {

	public static void main(String[] args) {

		Person per = new Student();
		
		System.out.println(per.getInfo());
	}

}
