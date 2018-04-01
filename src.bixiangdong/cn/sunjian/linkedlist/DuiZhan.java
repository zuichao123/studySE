package cn.sunjian.linkedlist;

import java.util.LinkedList;

/**
 * ¶ÑÕ»Á·Ï° ·½·¨
 * 
 * @author sunjian
 *
 */
public class DuiZhan {
	
	private LinkedList list;
	
	public DuiZhan(){
		list = new LinkedList();
	}
	
	public void  myAdd(Object obj){
		list.addFirst(obj);
	}
	
	public Object myGet(){
		return list.removeFirst();
	}
	
	public boolean isNull(){
		return list.isEmpty();
	}
}
