package cn.sunjian.collection_stack;

import java.util.Iterator;
import java.util.Stack;

/**
 * Stack�ࣺ
 * 	
 * 		ջ������ϰ��
 * 			��ջ����ջ
 * 
 * 		�Ƚ������ԭ��
 * 
 * @author sunjian
 *
 */
public class StackDemo {

	public static void main(String[] args) {

		Stack<String> stack = new Stack<String>();
	
		//��ջ
		stack.push("A");
		stack.push("B");
		stack.push("C");
		
		//��ջ
		Iterator<String> iterator = stack.iterator();
		while(iterator.hasNext()){			
			System.out.print(stack.pop()+"��");
		}
	}
	

}
