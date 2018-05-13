package cn.sunjian.collection;

import java.util.HashSet;
import java.util.Set;

/**
 * Set接口：内容不能重复
 * 
 * 		HashSet子类
 * 			散列存放
 * 
 * @author jack
 *
 */
public class HashSetDemo {

	public static void main(String[] args) {

		Set<String> allSet = new HashSet<String>();
		
		allSet.add("A");
		allSet.add("B");
		allSet.add("C");
		allSet.add("C");
		allSet.add("D");
		allSet.add("E");
		
		System.out.println(allSet);
		
		/*
		 * [A, B, C, D, E]
		 * 
		 * 是无序排列的，而List接口的内容插入的顺序就是其保存的顺序。如果现在希望所有的内容可以自动进行排序的操作，则可以使用Set中的第二个子类---->TreeSet。
		 */
		
	}

}
