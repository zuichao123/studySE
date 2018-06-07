package cn.sunjian.hasteset;

import java.util.HashSet;
import java.util.Iterator;

import cn.sunjian.p.bean.Person;

/**
 * 往hashSet集合中存储Person对象。
 * 如果姓名和年龄相同，视为同一个人。视为相同元素。
 * 
 * @author sunjian
 *
 */
public class HashSetTest {

	public static void main(String[] args) {
		
		HashSet<Person> hs = new HashSet<Person>();
		
		hs.add(new Person("lisi1",21));
		hs.add(new Person("lisi4",24));
		hs.add(new Person("lisi7",27));
		hs.add(new Person("lisi9",29));
		hs.add(new Person("lisi9",29));
		
		Iterator<Person> it = hs.iterator();
		
		while(it.hasNext()){
			Person p = (Person)it.next();
			System.out.println(p.getName()+"....."+p.getAge());
		}
		
	}

}
