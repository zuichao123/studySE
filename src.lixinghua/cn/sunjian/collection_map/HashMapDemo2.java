package cn.sunjian.collection_map;

import java.util.HashMap;
import java.util.Map;

/**
 * Map������ϰ��
 * 
 * 		HashMap�������ŵģ����µĲ����࣬key�������ظ���
 * 			���ӡ�ȡ������
 * 
 * 		��Ҫ��ϰ��
 * 			ʹ������������Ϊkey������value��
 * 			��key����Ϊ�����ʱ��ʵ����������hashCode()������equals()�������ж��������������Ƿ���ȡ�
 * 
 * @author jack
 *
 */
class Person{
	private String name;
	private int age;
	
	public Person(String name,int age){
		this.age = age;
		this.name = name;
	}
	public String toString(){
		return "������"+this.name+",���䣺"+this.age;
	}
	
	public boolean equals(Object obj){
		if (this == obj) {
			return true;
		}
		
		if (!(obj instanceof Person)) {
			return false;
		}
		
		Person p = (Person) obj;
		if (this.name.equals(p.name) && this.age == p.age) {
			return true;
		}else {
			return false;
		}
	}
	
	public int hashCode(){
		return this.name.hashCode() * this.age;
	}
}

public class HashMapDemo2 {

	public static void main(String[] args) {

		Map<Person, String> map = null;//����Map��������key��ֵ��һ�������value��ֵΪString����
		
		map = new HashMap<Person, String>();//����ʵ�������ӿڶ���
		
		map.put(new Person("sunjian", 30), "�｡");//key��һ����������
		
		System.out.println(map.get(new Person("sunjian", 30)));//����key����洢ʱ������������ͬ�����������ҵ�ֵ
	}
}
