package cn.sunjian.collection_manytomany;

import java.util.ArrayList;
import java.util.List;

/**
 * java类集：实例练习
 * 
 * 		多对多关系
 * 
 * 	实例要求：
 * 		一个学生可以选多门课程，一门课程可以有多个学生参加，那么这就是个典型的多对多关系。
 * 
 * 	思路：
 * 		要完成本程序，首先应该定义两个类：学生信息类Student、课程信息类Course，在一个学生类中存在一个集合，
 * 		保存全部的课程，而在课程类中也要存在一个集合，保存全部的学生。
 * 
 * @author sunjian
 *
 */
public class Course {

	private String name;
	private int credit;
	private List<Student> allStudents;
	
	public Course(){//通过构造方法实例化集合
		this.allStudents = new ArrayList<Student>();
	}
	
	public Course(String name,int credit){
		this();
		this.credit = credit;
		this.name = name;
	}
	
	//得到所有的学生
	public List<Student> getAllStudents(){
		return this.allStudents;
	}
	
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}
	
	public void setCredit(int credit){
		this.credit = credit;
	}
	public int getCredit(){
		return this.credit;
	}
	
	public String toString(){
		return "课程名称："+this.name+",编号："+this.credit;
	}
}
