package cn.sunjian.collection_stack;

import java.util.Iterator;
import java.util.Stack;

/**
 * Stack类：
 * 	
 * 		栈操作练习：
 * 			进栈、出栈
 * 
 * 		先进后出的原理
 * 
 * @author sunjian
 *
 */
public class StackDemo {

	public static void main(String[] args) {

		Stack<String> stack = new Stack<String>();
	
		//入栈
		stack.push("A");
		stack.push("B");
		stack.push("C");
		
		//出栈
		Iterator<String> iterator = stack.iterator();
		while(iterator.hasNext()){			
			System.out.print(stack.pop()+"、");
		}
	}
	

}
