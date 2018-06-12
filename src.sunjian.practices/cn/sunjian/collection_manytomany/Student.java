package cn.sunjian.collection_manytomany;

import java.util.ArrayList;
import java.util.List;

/**
 * java�༯��ʵ����ϰ
 * 
 * 		��Զ��ϵ
 * 
 * 	ʵ��Ҫ��
 * 		һ��ѧ������ѡ���ſγ̣�һ�ſγ̿����ж��ѧ���μӣ���ô����Ǹ����͵Ķ�Զ��ϵ��
 * 
 * 	˼·��
 * 		Ҫ��ɱ���������Ӧ�ö��������ࣺѧ����Ϣ��Student���γ���Ϣ��Course����һ��ѧ�����д���һ�����ϣ�
 * 		����ȫ���Ŀγ̣����ڿγ�����ҲҪ����һ�����ϣ�����ȫ����ѧ����
 * 
 * @author sunjian
 *
 */
public class Student {

	private String name;
	private int age;
	private List<Course> allCourses;
	
	public Student(){//���췽��ʵ��������
		this.allCourses = new ArrayList<Course>();
	}
	
	public Student(String name,int age){
		this();
		this.age = age;
		this.name = name;
	}
	
	//�õ����еĿγ�
	public List<Course> getAllCourses(){
		return this.allCourses;
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
	
	public String toString(){
		return "ѧ��������"+this.name+",���䣺"+this.age;
	}
}
