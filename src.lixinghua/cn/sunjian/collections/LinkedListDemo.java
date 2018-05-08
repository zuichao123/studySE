package cn.sunjian.collections;

import java.util.LinkedList;

/**
 * LinkedList集合操作练习：
 * 
 * 		链表操作
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
		
	}

}
