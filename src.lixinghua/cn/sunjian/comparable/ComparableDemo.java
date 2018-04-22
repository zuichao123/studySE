package cn.sunjian.comparable;

import java.util.Arrays;

/**
 * Comparable类操作练习：
 * 		
 *  比较器：
 * 	要求：
		定义一个学生类，里面有姓名、年龄、成绩三个属性，要求按成绩由高到底排序，如果成绩相等，则按照年龄由低到高排序；		
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
		return this.name+"："+this.age+"、"+this.score;
	}
	
	//覆写compareTo()方法，实现排序规则的应用
	public int compareTo(Student stu){
		if (this.score>stu.score) {
			return -1;
		}else if (this.score<stu.score) {
			return 1;//通过改变此处和上边的正负关系，可实现正序和倒叙。
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
			new Student("张三", 30, 90),
			new Student("李四", 28, 88.5f),
			new Student("王五", 20, 99.7f),
			new Student("jack", 30, 100.0f)
		};
		
		//数组排序
		Arrays.sort(stu);
		
		//打印数组内容
		for(int i=0;i<stu.length;i++){
			System.out.println(stu[i]);
		}
	}

}
