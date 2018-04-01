package cn.sunjian.generic.advance.demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class GenericAdvanceDemo {

	public static void main(String[] args) {
		
		ArrayList<String> al = new ArrayList<String>();

		al.add("abc");
		al.add("abd");
		al.add("abe");
		
		ArrayList<Integer> al2 = new ArrayList<Integer>();
		al2.add(8);
		al2.add(45);
		
		printCollection(al);
		printCollection(al2);
	}

	/**迭代并打印集合中的元素。
	 * @param al
	 */
	public static void printCollection(Collection<?> al) {
		Iterator<?> it = al.iterator();
		
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}

}
