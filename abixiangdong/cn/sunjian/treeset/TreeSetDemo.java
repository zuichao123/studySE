package cn.sunjian.treeset;

import java.util.Iterator;
import java.util.TreeSet;

import cn.sunjian.compratator.ComparatorByName;
import cn.sunjian.p.bean.Person;

/**
 * ��ϵtreeSet����
 * 
 * @author sunjian
 *
 */
public class TreeSetDemo {

	public static void main(String[] args) {

//		TreeSet ts = new TreeSet();
		//���ݱȽ������бȽ�
		TreeSet<Person> ts = new TreeSet<Person>(new ComparatorByName());
		
		ts.add(new Person("zhangsan",29));
		ts.add(new Person("wangwu",23));
		ts.add(new Person("lisi",29));
		ts.add(new Person("zhouqi",21));
		ts.add(new Person("zhaoliu",25));
		
		Iterator<Person> it = ts.iterator();
		
		while(it.hasNext()){
			Person p = (Person) it.next();
			
			System.out.println(p.getName()+"..."+p.getAge());
		}
	}

}
