package cn.sunjian.treemap;

import java.util.Comparator;

import cn.sunjian.hashmap.Student;

public class ComByName implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		int temp = o1.getName().compareTo(o2.getName());
		
		return temp==0?o1.getAge()-o2.getAge():temp;
	}

}
