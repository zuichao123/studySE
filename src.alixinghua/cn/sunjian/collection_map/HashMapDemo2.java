package cn.sunjian.collection_map;

import java.util.HashMap;
import java.util.Map;

/**
 * Map集合练习：
 * 
 * 		HashMap：无序存放的，是新的操作类，key不允许重复；
 * 			增加、取出内容
 * 
 * 		主要练习：
 * 			使用匿名对象作为key来查找value。
 * 			当key是作为对象的时候，实际上是依靠hashCode()方法和equals()方法来判断两个匿名对象是否相等。
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
		return "姓名："+this.name+",年龄："+this.age;
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

		Map<Person, String> map = null;//声明Map对象，其中key的值是一个对象和value的值为String类型
		
		map = new HashMap<Person, String>();//子类实例化父接口对象
		
		map.put(new Person("sunjian", 30), "孙健");//key是一个匿名对象
		
		System.out.println(map.get(new Person("sunjian", 30)));//根据key（与存储时的匿名对象相同的匿名对象）找到值
	}
}
