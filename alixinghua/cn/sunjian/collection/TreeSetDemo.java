package cn.sunjian.collection;

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

class Persons2 implements Comparable<Persons2>{
	private String name ;
	private int age ;
	public Persons2(String name,int age){
		this.name = name ;
		this.age = age ;
	}
	
	public String toString(){
		return "������" + this.name + "�����䣺" + this.age ;
	}
	
	public int compareTo(Persons2 per){
		if (this.age>per.age) {
			return 1;
		}else if (this.age<per.age) {
			return -1;
		} else {
			return this.name.compareTo(per.name);//����String�е�compareTo()������������Ҳ�����Ƚ�
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
		 * ��������,���ݲ����ظ�
		 */
		
		
		Set<Persons2> allSet = new TreeSet<Persons2>() ;
		
		allSet.add(new Persons2("����",30)) ;
		allSet.add(new Persons2("����",31)) ;
		allSet.add(new Persons2("����",32)) ;
		allSet.add(new Persons2("����",32)) ;
		allSet.add(new Persons2("����",32)) ;
		allSet.add(new Persons2("����",33)) ;
		allSet.add(new Persons2("����",33)) ;
		
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
