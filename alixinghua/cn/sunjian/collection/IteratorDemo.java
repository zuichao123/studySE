package cn.sunjian.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Itreator接口：单向输出
 * 		
 * 		常用方法练习：
 * 			输出内容
 * 			删除内容
 * 
 * @author jack
 *
 */
public class IteratorDemo {

	public static void main(String[] args) {

		List<String> allList = new ArrayList<String>();
		
		allList.add("hello");
		allList.add("hello1");
		allList.add("_");		
		allList.add("world");
		
		Iterator<String> iterator = allList.iterator();//通过iterator()方法给Iterator接口实例化
		
		while(iterator.hasNext()){//判断是否有内容
			String str = iterator.next();
			if ("_".equals(str)) {
				iterator.remove();//删除此元素
			}else {				
				System.out.println(str);//输出内容
			}
		}
		
		/*
		 * 在实际操作中，很少调用remove()方法，因为其主要的作用是输出。
		 */
	}

}
