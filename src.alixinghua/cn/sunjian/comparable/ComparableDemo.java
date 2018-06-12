package cn.sunjian.comparable;

import java.util.Arrays;

/**
 * Comparable�������ϰ��
 * 		
 *  �Ƚ�����
 * 	Ҫ��
		����һ��ѧ���࣬���������������䡢�ɼ��������ԣ�Ҫ�󰴳ɼ��ɸߵ�����������ɼ���ȣ����������ɵ͵�������		
 * 
 * @author sunjian
 *
 */
class Student implements Comparable<Student>{
	private String name;
	private int age;
	private float score;
	
	public Student(String name,int age,float score){
		this.age = age;
		this.name = name;
		this.score = score;
	}
	public String toString(){
		return this.name+"��"+this.age+"��"+this.score;
	}
	
	//��дcompareTo()������ʵ����������Ӧ��
	public int compareTo(Student stu){
		if (this.score>stu.score) {
			return -1;
		}else if (this.score<stu.score) {
			return 1;//ͨ���ı�˴����ϱߵ�������ϵ����ʵ������͵���
		}else {
			if (this.age>stu.age) {
				return 1;
			}else if (this.age<stu.age) {
				return -1;
			}else {
				return 0;
			}
		}
	}
		
}


public class ComparableDemo {

	public static void main(String[] args) {
		
		Student stu[] = {
			new Student("����", 30, 90),
			new Student("����", 28, 88.5f),
			new Student("����", 20, 99.7f),
			new Student("jack", 30, 100.0f)
		};
		
		//��������
		Arrays.sort(stu);
		
		//��ӡ��������
		for(int i=0;i<stu.length;i++){
			System.out.println(stu[i]);
		}
	}

}
