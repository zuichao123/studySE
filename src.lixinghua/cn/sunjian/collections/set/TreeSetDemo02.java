package cn.sunjian.collections.set;

import java.util.Set;
import java.util.TreeSet;

/**
 * Set�ӿڣ����ݲ����ظ�
 * 
 * 		TreeSet����
 * 				������
 * 				��������
 * 
 * @author jack
 *
 */

class Person implements Comparable<Person>{
	private String name ;
	private int age ;
	public Person(String name,int age){
		this.name = name ;
		this.age = age ;
	}
	
	public String toString(){
		return "������" + this.name + "�����䣺" + this.age ;
	}
	
	public int compareTo(Person per){
		if (this.age>per.age) {
			return 1;
		}else if (this.age<per.age) {
			return -1;
		} else {
			return this.name.compareTo(per.name);//����String�е�compareTo()������������Ҳ�����Ƚ�
		}
	}
}

public class TreeSetDemo02{
	public static void main(String args[]){
		
		Set<Person> allSet = new TreeSet<Person>() ;
		
		allSet.add(new Person("����",30)) ;
		allSet.add(new Person("����",31)) ;
		allSet.add(new Person("����",32)) ;
		allSet.add(new Person("����",32)) ;
		allSet.add(new Person("����",32)) ;
		allSet.add(new Person("����",33)) ;
		allSet.add(new Person("����",33)) ;
		
		System.out.println(allSet) ;
		
		/*
		 * һ����������Ҫ������������Comparable�ӿ���ɡ�
		 * ��ô����treeSetһ�������Ҫʹ��TreeSet��������Ĳ�����Ҳ����ʵ��Comparable�ӿڡ�
		 * 
		 * String���Ȼ����ʹ��TreeSet������String�п϶��Ѿ�ʵ����Comparable�ӿڡ�
		 * 
		 * �����Ҫȡ�����ظ�Ԫ�أ�����ҪObject���е���������������
		 * 	1.hashCode()����ʾһ��Ψһ�ı��룬һ��ͨ�������ʾ��
		 * 	2.equals()�����ж���ıȽϲ�����
		 */
	}
}
