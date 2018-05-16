package cn.sunjian.arraylist.test;

import java.util.ArrayList;
import java.util.Iterator;

import cn.sunjian.p.bean.Person;

/**
 * 将一个容器中的元素，取唯一值，并存入另一个容器中
 * 
 * 思路：
 * 1.遍历容器中的元素
 * 2.遍历是判断当前元素是否在新的容器中存在，如存在不存储，如不存在，存储
 * 
 * @author sunjian
 *
 */
public class ArrayListTest2 {

	public static void main(String[] args) {
		
		singleDemo();
		
		ArrayList<Person> al = new ArrayList<Person>();
		
		al.add(new Person("lisi1",21));
		al.add(new Person("lisi2",22));
		al.add(new Person("lisi1",21));
		al.add(new Person("lisi3",23));
		al.add(new Person("lisi4",24));
		al.add(new Person("lisi2",22));
		al.add(new Person("lisi3",23));

		
		
		System.out.println(al);//打印当前容器元素
		
		al = getSingleElement(al);

		Person per = null;
		Iterator<Person> iterator = al.iterator();
		
		System.out.print("[");
		while(iterator.hasNext()){
			per = iterator.next();
			//打印去重后的容器元素
			System.out.print(per+", ");
		}
		System.out.print("]");
		
	}

	/**
	 * 
	 */
	public static void singleDemo() {
		
		ArrayList al = new ArrayList();
		al.add("abc1");
		al.add("abc2");
		al.add("abc1");
		al.add("abc7");
		al.add("abc8");
		al.add("abc3");
		al.add("abc7");
		
		System.out.println(al);//打印当前容器元素
		
		//去重容器元素
		al = getSingleElement(al);
		
		System.out.println(al);//打印去重后的容器
	}

	public static ArrayList getSingleElement(ArrayList al) {
		
		//创建一个新容器
		ArrayList temp = new ArrayList();
		
		//遍历旧容器;并判断新容器中是否包含当前元素，如不包含，就存储；如包含就不存储
		Iterator it = al.iterator();
		while(it.hasNext()){
			Object obj = it.next();		
			if (!temp.contains(obj)) {				
				temp.add(obj);
			}
		}
		
		return temp;
	}

}
