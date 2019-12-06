package cn.sunjian.collection_map;

import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Map集合练习：
 * 
 * 		IdentityHashMap：
 * 			由于HashMap的key不能重复，所以如果现在希望key的内容可以重复（对象的地址不一样），则要使用IdentityHashMap类。
 * 
 * @author jack
 *
 */
class Person2{
	private String name;
	private int age;
	
	public Person2(String name,int age){
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
		
		if (!(obj instanceof Person2)) {
			return false;
		}
		
		Person2 p = (Person2) obj;
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

public class IdentityHashMapDemo {

	public static void main(String[] args) {

		Map<Person2, String> map = null;//声明Map对象，其中key的值是一个对象和value的值为String类型
		
		map = new IdentityHashMap<Person2, String>();//子类实例化父接口对象
		
		map.put(new Person2("sunjian", 30), "孙健");//key是一个匿名对象
		map.put(new Person2("sunjian", 30), "孙健2");//key是一个匿名对象
		map.put(new Person2("sunjian", 30), "孙健3");//key是一个匿名对象
		
		Set<Map.Entry<Person2, String>> allSet = null;
		allSet = map.entrySet();
		
		Iterator<Map.Entry<Person2, String>> iter = allSet.iterator();
		
		while(iter.hasNext()){
			Map.Entry<Person2, String> sss = iter.next();
			
			System.err.println(sss.getKey()+"-->"+sss.getValue());
		}
	}
}
