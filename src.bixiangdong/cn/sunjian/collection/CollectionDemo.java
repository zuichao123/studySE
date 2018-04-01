package cn.sunjian.collection;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 集合框架
 * 
 * @author sunjian
 *
 */
public class CollectionDemo {

	public static void main(String[] args) {
		
		Collection coll = new ArrayList();
		
//		show(coll);
		
		Collection c1 = new ArrayList();
		Collection c2 = new ArrayList();
		
		show(c1,c2);
		
	}
	
	public static void show(Collection c1, Collection c2){
		
		//给c1添加元素
		c1.add("abc1");
		c1.add("abc2");
		c1.add("abc3");
		c1.add("abc4");
		
		//给c2添加元素
		c2.add("abc2");
		c2.add("abc1");
		c2.add("abc4");
		
		System.out.println("c1："+c1);
		System.out.println("c2："+c2);
		
		//演示addAll方法
		c1.addAll(c2);
		
		System.out.println("addAll--把c2添加到c1中:"+c1);	
		
		//演示removeAll方法
//		boolean b = c1.removeAll(c2);
//		System.out.println("removeAll--删除c1中所有的c2集合后："+c1);
//		System.out.println("是否删除成功："+b);
		
		//演示containsAll
		boolean b1 = c1.containsAll(c2);
		System.out.println("containAll--c1集合中包含c2集合中的："+c2);
		System.out.println("containsAll--c1集合中是否包含c2集合中的所有内容："+b1);
		
		//演示retainAll
		boolean b2 = c1.retainAll(c2);
		System.out.println("retainAll--取c1集合与c2集合的交集："+c1);
		System.out.println("c1集合与c2集合是否有交集"+b2);
		
	}
	
	public static void show(Collection coll){
		
		//1.添加元素。add
		coll.add("abc1");
		coll.add("abc2");
		coll.add("abc3");
		
		System.out.println(coll);
		
		//2.删除元素。remove
		coll.remove("abc2");//会改变集合的长度
		
		//清空集合
//		coll.clear();
		
		System.out.println(coll.isEmpty());
		System.out.println(coll.contains("abc3"));
		
		System.out.println(coll);
		
	}

}
