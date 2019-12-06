package cn.sunjian.collection_collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Collections工具类：
 * 	
 * 		
 * 
 * @author sunjian
 *
 */
public class CollectionsDemo {

	public static void main(String[] args) {
		
		List<String> list2 = new ArrayList<String>();
		
		//为集合添加内容
		Collections.addAll(list2, "hello","world","你好","世界");
		Collections.addAll(list2, "hello2","world2","你好2","世界2");
		Collections.addAll(list2, "hello3","world3","你好3","世界3");
		printCollection(list2);
		
		//内容反转
		Collections.reverse(list2);
		System.out.println("反转后的内容：");
		printCollection(list2);
		
		//内容检索
		int point = Collections.binarySearch(list2, "hello");
		System.out.println("检索结果："+point);
		
		//替换指定内容		
		if (Collections.replaceAll(list2, "hello", "Hello")) {
			System.out.println("替换后的内容：");
			printCollection(list2);
		}else {
			System.out.println("替换失败！");
		}
		
		//排序
		Collections.sort(list2);
		System.out.println("排序后的内容：");
		printCollection(list2);
		
		//指定位置交换
		Collections.swap(list2, 3, 6);
		System.out.println("交换后的内容：");
		printCollection(list2);
		
		/*
		 * Collections的其他方法
		 */
		@SuppressWarnings("unused")
		List<String> list = Collections.emptyList();//返回不可变的空List集合
		@SuppressWarnings("unused")
		Set<String> set = Collections.emptySet();//返回不可变的空Set集合
		
		//list.add("hello");//错误的，不可以加入内容
		//set.add("world");//错误的，不可以加入内容
		
		
	}

	private static void printCollection(List<String> list2) {
		Iterator<String> iterator = list2.iterator();
		while(iterator.hasNext()){
			System.out.print(iterator.next()+"、");
		}
		System.out.println();
	}

}
