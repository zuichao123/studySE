package cn.sunjian.generic;

import java.util.Iterator;
import java.util.TreeSet;

import cn.sunjian.generic_bean.Person1;
import cn.sunjian.generic_comparator.ComparatorByName;

/**
 * ÑÝÊ¾·ºÐÍ
 * 
 * @author sunjian
 *
 */
public class GenericDemo {

	public static void main(String[] args) {

		TreeSet<Person1> ts = new TreeSet<Person1>(new ComparatorByName());
		
		ts.add(new Person1("lisi9",21));
		ts.add(new Person1("lisi7",23));
		ts.add(new Person1("lisi9",21));
		ts.add(new Person1("lisi0",20));
		ts.add(new Person1("lisi5",25));
		
		Iterator<Person1> it = ts.iterator();
		
		while(it.hasNext()){
			
			Person1 p = it.next();
//			System.out.println(p);
			System.out.println(p.getAge()+"..."+p.getName());
		}
	}

}
