package cn.sunjian.collection.onetoone;

/**
 * java�༯��ʵ����ϰ
 * 
 * 		һ�Զ��ϵ
 * 
 * 	ʵ��Ҫ��
 * 		ʹ���༯���Ա�ʾ�����¹�ϵ��һ��ѧУ���԰������ѧ����һ��ѧ������һ��ѧУ��
 * 		�����һ�����͵�һ�Զ��ϵ����ʱ�Ϳ���ͨ���༯���й�ϵ�ı�ʾ��
 * 
 * 	˼·��
 * 		һ��ѧУ�ж��ѧ������ôѧ���ĸ�������δ֪�ģ���ô����һ���϶��޷�ʹ����ͨ�Ķ��������ʾ��
 * 		���ԣ�����ͨ���༯��ʾ��
 * 
 * @author sunjian
 *
 */
public class Student {

	private String name;
	private int age;
	private School school;//һ��ѧ������һ��ѧУ
	
	public Student(String name,int age){
		this.age = age;
		this.name = name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}
	
	public void setAge(int age){
		this.age = age;
	}
	public int getAge(){
		return this.age;
	}
	
	public void setSchool(School school){
		this.school = school;
	}
	public School getSchool(){
		return this.school;
	}
	
	public String toString(){
		return "ѧ��������"+ this.name + "��ѧ�����䣺" + this.age;
	}
}
