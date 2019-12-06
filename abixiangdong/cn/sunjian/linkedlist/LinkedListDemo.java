package cn.sunjian.linkedlist;

import java.util.LinkedList;

/**
 * ��ϰLinkedList
 * 
 * @author sunjian
 *
 */
public class LinkedListDemo {

	public static void main(String[] args) {

		LinkedList<String> link = new LinkedList<String>();
		
		link.addFirst("abc1");
		link.addFirst("abc2");
		link.addFirst("abc3");
		link.addFirst("abc4");
		
		System.out.println(link);
		
		System.out.println(link.getFirst());
		System.out.println(link.getLast());
		
		System.out.println(link.removeLast());
		System.out.println(link.removeFirst());
		
		while(!link.isEmpty()){
			System.out.println(link.removeFirst());
		}
		
		System.out.println(link);
		
	}

}
