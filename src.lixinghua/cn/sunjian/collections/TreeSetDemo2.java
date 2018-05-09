package cn.sunjian.collections;

import java.util.Set;
import java.util.TreeSet;

/**
 * Set接口：内容不能重复
 * 
 * 		TreeSet子类
 * 			有序存放
 * 
 * @author jack
 *
 */

class Persons{
	private String name;
	private int age;
	
	public Persons(String name, int age){
		this.age = age;
		this.name = name;
	}
	public String toString(){
		return "姓名："+this.name+"， 年龄："+this.age;
	}
}



public class TreeSetDemo2 {

	public static void main(String[] args) {

		Set<Persons> allSet = new TreeSet<Persons>();
		
		allSet.add(new Persons("李四", 30));
		allSet.add(new Persons("王五", 33));
		allSet.add(new Persons("张三", 29));
		allSet.add(new Persons("张三", 29));
		allSet.add(new Persons("张三", 29));
		allSet.add(new Persons("赵六", 32));
		
		System.out.println(allSet);
		
	}

}
