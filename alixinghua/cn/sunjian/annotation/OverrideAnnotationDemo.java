package cn.sunjian.annotation;
/**
 * Annotation��ע��
 * 
 * 		@Override����鸲д����ȷ��
 * 
 * @author jack
 *
 */
class Person{
	public String getInfo(){
		return "����һ��Person�ࡣ����";
	}
}
class Student extends Person{
	@Override//��鸲д��������ȷ��
	public String getInfo(){
		return "����һ��Student��...";
	}
}
public class OverrideAnnotationDemo {

	public static void main(String[] args) {

		Person per = new Student();
		
		System.out.println(per.getInfo());
	}

}
