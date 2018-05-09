package cn.sunjian.collections;

import java.util.Set;
import java.util.TreeSet;

/**
 * Set接口：内容不能重复
 * 
 * 		TreeSet子类
 * 			有序存放
 * 
 * @author jack
 *
 */
public class TreeSetDemo {

	public static void main(String[] args) {

		Set<String> allSet = new TreeSet<String>();
		
		allSet.add("A");
		allSet.add("B");
		allSet.add("C");
		allSet.add("C");
		allSet.add("D");
		allSet.add("E");
		
		System.out.println(allSet);
		
	}

}
