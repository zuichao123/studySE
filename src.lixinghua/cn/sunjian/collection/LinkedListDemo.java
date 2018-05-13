package cn.sunjian.collection;

import java.util.LinkedList;

/**
 * LinkedList集合操作练习：
 * 
 * 		链表操作：
 * 			增加元素、表头、表尾
 * 			找表头(删除、不删除)
 * 
 * @author jack
 *
 */
public class LinkedListDemo {

	public static void main(String[] args) {

		LinkedList<String> link = new LinkedList<String>();
		
		link.add("A1");//增加元素
		link.add("A2");
		link.add("A3");
		System.out.println("初始化链表："+link);
		
		link.addFirst("B1");//在链表开头增加数据
		link.addLast("B2");//在链表结尾增加数据	
		System.out.println("增加头和尾之后的链表："+link);
		
		System.out.println("\n使用element()方法，找到表头："+link.element());
		System.out.println("找完之后的链表内容："+link);
		
		System.out.println("\n使用peek()方法找到表头："+link.peek());
		System.out.println("找完之后的链表内容："+link);
		
		System.out.println("\n使用poll()方法找到表头："+link.poll());
		System.out.println("找完之后的链表内容："+link);
		
		System.out.println(link.size());
		
		System.out.println("\n以FIFO的方式输出：");
		for(int i=0;i<=link.size()+1;i++){//先进先出的方式输出
			System.out.print(link.poll()+"、");
		}
		
	}

}
