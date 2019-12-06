package cn.sunjian.collection;

import java.util.HashSet;
import java.util.Set;

/**
 * Set�ӿڣ����ݲ����ظ�
 * 
 * 		HashSet:
 * 			����ȥ��
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
	 *��дtoString����
	 */
	public String toString(){
		return "������" + this.name + "�����䣺" + this.age ;
	}
	
	/*
	 * ��дequals����
	 */
	public boolean equals(Object obj){
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Persons)) {
			return false;
		}
		
		Persons p = (Persons)obj;//����ת��
		if (this.name.equals(p.name) && this.age == p.age) {
			return true;
		}else {
			return false;
		}
	}
	
	/*
	 * ��дhashcode����
	 */
	public int hashCode(){
		return this.name.hashCode() * this.age;//�Զ���һ����ʽ
	}
}

public class RepeatDemo{
	public static void main(String args[]){
		
		Set<Persons> allSet = new HashSet<Persons>() ;
		
		allSet.add(new Persons("����",30)) ;
		allSet.add(new Persons("����",31)) ;
		allSet.add(new Persons("����",32)) ;
		allSet.add(new Persons("����",32)) ;
		allSet.add(new Persons("����",32)) ;
		allSet.add(new Persons("����",33)) ;
		allSet.add(new Persons("����",33)) ;
		
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
