package cn.sunjian.linkedlist;

import java.util.LinkedList;

public class DuiLie {

	private LinkedList<Object> link;
	
	public DuiLie() {
		link = new LinkedList<Object>();
	}
	
	
	/**
	 * 队列的功能
	 * @param obj
	 */
	public void myAdd(Object obj){
		link.addLast(obj);
	}
	
	public Object myGet(){
		return link.removeFirst();
	}
	
	public boolean isNull(){
		return link.isEmpty();
	}

}
