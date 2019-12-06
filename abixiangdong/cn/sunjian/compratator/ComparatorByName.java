package cn.sunjian.compratator;

import java.util.Comparator;

import cn.sunjian.p.bean.Person;

/**
 * 定义一个Person类的比较器,根据name进行比较
 * 
 * @author sunjian
 *
 */
public class ComparatorByName implements Comparator<Object> {

	@Override
	public int compare(Object o1, Object o2) {
		
		Person p1 = (Person)o1;
		Person p2 = (Person) o2;
		
		int temp = p1.getName().compareTo(p2.getName());
		
		return temp==0?p1.getAge()-p2.getAge():temp;
	}

}
