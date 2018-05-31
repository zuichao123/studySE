package cn.sunjian.generic_advance;

import java.sql.Array;
import java.util.ArrayList;

import cn.sunjian.generic_bean.Person1;
import cn.sunjian.generic_bean.Student;
import cn.sunjian.generic_bean.Worker;

/**
 * 演示泛型的高级应用---上限
 * 
 * @author sunjian
 *
 */
public class GenericAdvanceDemo2 {

	public static void main(String[] args) {
		
		ArrayList<Person1> al1 = new ArrayList<Person1>();
		al1.add(new Person1("abdf1",20));
		al1.add(new Person1("abdf2",22));
		al1.add(new Person1("abdf3",23));
		
		ArrayList<Student> al2 = new ArrayList<Student>();
		al2.add(new Student("sd2",22));
		al2.add(new Student("sd3",23));
		al2.add(new Student("sd4",24));
		
		ArrayList<Worker> al3 = new ArrayList<Worker>();
		al3.add(new Worker("dad3",33));
		al3.add(new Worker("dad4",34));
		al3.add(new Worker("dad5",35));
		
		ArrayList<String> al4 = new ArrayList<String>();
		al4.add("ghjhygfds");
		
		al1.addAll(al2);
		al1.addAll(al3);
		
		System.out.println(al1.size());
	}

}

/**
 * 一般存储时，使用上限
 * @author sunjian
 *
 * @param <E>
 */
class MyCelloction<E>{
	
	public void add(E e){
		
	} 
	public void addAll(MyCelloction<? extends E> e){
		
	}
}
