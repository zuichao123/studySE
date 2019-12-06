package cn.sunjian.collection;

import java.util.HashSet;
import java.util.Set;

/**
 * Set接口：内容不能重复
 * 
 * 		HashSet:
 * 			排序，去重
 * 
 * @author jack
 *
 */

class Persons{
	private String name ;
	private int age ;
	public Persons(String name,int age){
		this.name = name ;
		this.age = age ;
	}
	
	/*
	 *覆写toString方法
	 */
	public String toString(){
		return "姓名：" + this.name + "；年龄：" + this.age ;
	}
	
	/*
	 * 覆写equals方法
	 */
	public boolean equals(Object obj){
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Persons)) {
			return false;
		}
		
		Persons p = (Persons)obj;//向下转型
		if (this.name.equals(p.name) && this.age == p.age) {
			return true;
		}else {
			return false;
		}
	}
	
	/*
	 * 覆写hashcode方法
	 */
	public int hashCode(){
		return this.name.hashCode() * this.age;//自定义一个公式
	}
}

public class RepeatDemo{
	public static void main(String args[]){
		
		Set<Persons> allSet = new HashSet<Persons>() ;
		
		allSet.add(new Persons("张三",30)) ;
		allSet.add(new Persons("李四",31)) ;
		allSet.add(new Persons("王五",32)) ;
		allSet.add(new Persons("王五",32)) ;
		allSet.add(new Persons("王五",32)) ;
		allSet.add(new Persons("赵六",33)) ;
		allSet.add(new Persons("孙七",33)) ;
		
		System.out.println(allSet) ;
		
		/*
		 * 一个对象数组要想排序，则依靠Comparable接口完成。
		 * 那么对于treeSet一样，如果要使用TreeSet进行排序的操作，也必须实现Comparable接口。
		 * 
		 * String类既然可以使用TreeSet排序，则String中肯定已经实现了Comparable接口。
		 * 
		 * 如果想要取消掉重复元素，则需要Object类中的两个方法帮助：
		 * 	1.hashCode()：表示一个唯一的编码，一般通过计算表示；
		 * 	2.equals()：进行对象的比较操作；
		 */
	}
}
