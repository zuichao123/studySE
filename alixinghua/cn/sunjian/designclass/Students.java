package cn.sunjian.designclass;

/**
 * 面向对象基础：类设计分析
 * 
 * 设计一个类，包括学生的学号、姓名、英语成绩、数学成绩、计算机成绩
 * 
 * 计算学生的总分、最高分、平均分、最低分
 * 
 * @author sunjian
 *
 */

class Student{
	
	//属性
	private String stuno;
	private String name;
	private float macth;
	private float english;
	private float computer;
	
	//构造方法
	public Student(){}
	public Student(String stuno, String name, float macth, float english, float computer) {
		this.stuno = stuno;
		this.name = name;
		this.macth = macth;
		this.english = english;
		this.computer = computer;
	}
	
	public String getStuno() {
		return stuno;
	}
	public String getName(){
		return name;
	}
	public float getMacth(){
		return macth;
	}
	public float getEnglish(){
		return english;
	}
	public float getComputer(){
		return computer;
	}
	
	public void setStuno(String stuno) {
		this.stuno = stuno;
	}
	public void setName(String name){
		this.name = name;
	}
	public void setMacth(float m){
		this.macth = m;
	}
	public void setEnglish(float e){
		this.english = e;
	}
	public void setComputer(float c){
		this.computer = c;
	}
	
	/*
	 * 求出所有的学生成绩的总分
	 */
	public float sum(){
		return macth+english+computer;
	}
	/*
	 * 求出所有学生总成绩的平均分
	 */
	public float avg(){
		return sum() / 3;
	}
	/*
	 * 求出所有学生的最高分科目
	 */
	public float max(){
		float max = macth;
		
		max = max>computer?max:computer;
		max = max>english?max:english;
		
		return max;
	}
	/*
	 * 求出所有学生科目的最低分
	 */
	public float min(){
		float min = macth;
		
		min = min<computer?min:computer;
		min = min<english?min:english;
		
		return min;
	}
	
}

public class Students{
		
	public static void main(String[] args) {
		Student student = new Student("xy-6-1-001", "孙智博", 100, 98, 95);
		
		System.out.println("学生姓名："+student.getName());
		System.out.println("学生学号："+student.getStuno());
		System.out.println("总分："+student.sum());
		System.out.println("最高分："+student.max());
		System.out.println("最低分："+student.min());
		System.out.println("平均分："+student.avg());
	}
		
}
