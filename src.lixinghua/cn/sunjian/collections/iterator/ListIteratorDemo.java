package cn.sunjian.collections.iterator;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * ListItreator接口：双向输出
 * 		
 * 		常用方法练习：
 * 			输出内容
 * 			修改内容
 * 			增加内容
 * 
 * @author jack
 *
 */
public class ListIteratorDemo {

	public static void main(String[] args) {

		List<String> allList = new ArrayList<String>();
		
		allList.add("hello");
		allList.add("hello1");
		allList.add("_");		
		allList.add("world");
		
		ListIterator<String> iterator = allList.listIterator();//通过iterator()方法给Iterator接口实例化
		
		System.out.print("由前向后输出：");
		while(iterator.hasNext()){//判断是否有内容
			String str = iterator.next();
			System.out.print(str+"、");//输出内容
			iterator.set("sun"+str);//修改内容
		}
		
		
		System.out.print("\n由后向前输出：");
		while(iterator.hasPrevious()){
			iterator.add("sun");
			String str = iterator.previous();
			System.out.print(str+"、");
		}
		
		/*
		 * 注意：此操作时，必须先进行由前向后，再进行右后向前的操作。
		 * 	   如果要想使用ListIterator接口，则只能依靠List接口完成；
		 */
	}

}
