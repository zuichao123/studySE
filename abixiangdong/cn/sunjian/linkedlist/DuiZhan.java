package cn.sunjian.linkedlist;

import java.util.LinkedList;

/**
 * ¶ÑÕ»Á·Ï° ·½·¨
 * 
 * @author sunjian
 *
 */
public class DuiZhan {
	
	private LinkedList<Object> list;
	
	public DuiZhan(){
		list = new LinkedList<Object>();
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
