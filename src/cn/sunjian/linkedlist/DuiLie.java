package cn.sunjian.linkedlist;

import java.util.LinkedList;

public class DuiLie {

	private LinkedList link;
	
	public DuiLie() {
		link = new LinkedList();
	}
	
	
	/**
	 * ���еĹ���
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
