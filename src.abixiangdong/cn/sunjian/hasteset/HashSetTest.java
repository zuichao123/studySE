package cn.sunjian.hasteset;

import java.util.HashSet;
import java.util.Iterator;

import cn.sunjian.p.bean.Person;

/**
 * ��hashSet�����д洢Person����
 * ���������������ͬ����Ϊͬһ���ˡ���Ϊ��ͬԪ�ء�
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
