package cn.sunjian.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 练习iterator
 * @author sunjian
 *
 */
public class IteratorDemos {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		
		Collection coll = new ArrayList();
		
		coll.add("abc1");
		coll.add("abc2");
		coll.add("abc3");
		coll.add("abc4");

		//使用了Collection中的iterator()方法;调用集合中的迭代器方法，是为了获取集合中的迭代器对象。
		 
		//这种while循环取值，取完值后，it迭代器还在内存中
		Iterator it = coll.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
		System.out.println("***************************************");
		
		//开发中使用这种
		for(Iterator it1 = coll.iterator(); it1.hasNext(); ){
			System.out.println(it1.next());
		}
		
	}

}
