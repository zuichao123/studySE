package cn.sunjian.generic_advance;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

import cn.sunjian.generic_bean.Person1;
import cn.sunjian.generic_bean.Student;
import cn.sunjian.generic_bean.Worker;

/**
 * 泛型高级应用----下限
 * @author sunjian
 *
 */
public class GenericAdvanceDemo3 {

	public static void main(String[] args) {

		TreeSet<Person1> al1 = new TreeSet<Person1>(new CompByName());
		al1.add(new Person1("abdf1",20));
		al1.add(new Person1("abdf4",27));
		al1.add(new Person1("abdf9",23));
		
		TreeSet<Student> al2 = new TreeSet<Student>(new CompByName());
		al2.add(new Student("sd2",22));
		al2.add(new Student("sd3",23));
		al2.add(new Student("sd4",24));
		
		TreeSet<Worker> al3 = new TreeSet<Worker>(new CompByName());
		al3.add(new Worker("dad3",33));
		al3.add(new Worker("dad9",30));
		al3.add(new Worker("dad5",35));
		
		TreeSet<String> al4 = new TreeSet<String>();
		al4.add("ghjhygfds");
		
		al1.addAll(al3);
		
		Iterator<Person1> it = al1.iterator();
		while(it.hasNext()){
			System.out.println(it.next().toString());
		}
		
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&");
		
		Iterator<Worker> it1 = al3.iterator();
		while(it1.hasNext()){
			System.out.println(it1.next().toString());
		}
	}

}
/**
 * 取出元素时，使用下限
 * 就是存什么，用什么接收、或者父类接收。
 * @author sunjian
 *
 */
class CompByName implements Comparator<Person1>{

	@Override
	public int compare(Person1 o1, Person1 o2) {
		
		int temp = o1.getName().compareTo(o2.getName());
		
		return temp==0?o1.getAge()-o2.getAge():temp;
	}
	
}
