package cn.sunjian.collections;

import java.util.Set;
import java.util.TreeSet;

/**
 * Set�ӿڣ����ݲ����ظ�
 * 
 * 		TreeSet����
 * 			������
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
		return "������"+this.name+"�� ���䣺"+this.age;
	}
}



public class TreeSetDemo2 {

	public static void main(String[] args) {

		Set<Persons> allSet = new TreeSet<Persons>();
		
		allSet.add(new Persons("����", 30));
		allSet.add(new Persons("����", 33));
		allSet.add(new Persons("����", 29));
		allSet.add(new Persons("����", 29));
		allSet.add(new Persons("����", 29));
		allSet.add(new Persons("����", 32));
		
		System.out.println(allSet);
		
	}

}
