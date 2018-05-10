package cn.sunjian.collections.set;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * SortedSet接口：练习
 * 
 * 		练习SortedSet接口中的方法
 * 
 * @author jack
 *
 */
public class SortedSetDemo {

	public static void main(String[] args) {

		SortedSet<String> allSet = new TreeSet<String>();
		
		allSet.add("A");
		allSet.add("B");
		allSet.add("C");
		allSet.add("C");
		allSet.add("C");
		allSet.add("D");
		allSet.add("E");
		
		System.out.println("第一个元素："+allSet.first());
		System.out.println("最后一个元素："+allSet.last());
		System.out.println("headSet元素："+allSet.headSet("C"));//从“c”之前的元素
		System.out.println("tailSet元素："+allSet.tailSet("C"));//从“C”之后的元素
		System.out.println("subSet元素："+allSet.subSet("B", "D"));//“B”到“D”之间的元素
	}

}
