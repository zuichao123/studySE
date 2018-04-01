package cn.sunjian.generic.comparator;

import java.util.Comparator;

import cn.sunjian.generic.bean.Person1;

public class ComparatorByName implements Comparator<Person1> {

	@Override
	public int compare(Person1 o1, Person1 o2) {
		
		int temp = o1.getName().compareTo(o2.getName());
		
		return temp==0?o1.getAge()-o2.getAge():temp;
		
	}

}
