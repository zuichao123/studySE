package cn.sunjian.collection;

import java.util.Set;
import java.util.TreeSet;

/**
 * Set接口：内容不能重复
 * 
 * 		TreeSet子类
 * 				有序存放
 * 				对象排序
 * 
 * @author jack
 *
 */

class Persons2 implements Comparable<Persons2>{
	private String name ;
	private int age ;
	public Persons2(String name,int age){
		this.name = name ;
		this.age = age ;
	}
	
	public String toString(){
		return "姓名：" + this.name + "；年龄：" + this.age ;
	}
	
	public int compareTo(Persons2 per){
		if (this.age>per.age) {
			return 1;
		}else if (this.age<per.age) {
			return -1;
		} else {
			return this.name.compareTo(per.name);//调用String中的compareTo()方法，对姓名也做个比较
		}
	}
}

public class TreeSetDemo{
	public static void main(String args[]){
		
		Set<String> set = new TreeSet<String>();
		
		set.add("D");
		set.add("A");
		set.add("E");
		set.add("B");
		set.add("C");
		set.add("C");
		
		System.out.println(set);
		
		/*
		 * 有序排列,内容不可重复
		 */
		
		
		Set<Persons2> allSet = new TreeSet<Persons2>() ;
		
		allSet.add(new Persons2("张三",30)) ;
		allSet.add(new Persons2("李四",31)) ;
		allSet.add(new Persons2("王五",32)) ;
		allSet.add(new Persons2("王五",32)) ;
		allSet.add(new Persons2("王五",32)) ;
		allSet.add(new Persons2("赵六",33)) ;
		allSet.add(new Persons2("孙七",33)) ;
		
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
