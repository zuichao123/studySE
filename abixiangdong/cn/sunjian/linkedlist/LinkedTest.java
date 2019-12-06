package cn.sunjian.linkedlist;

/**
 * 请使用LinkedList来模拟一个堆栈或者队列数据结构。
 * 
 * 堆栈：先进后出First In Last Out FILO
 * 队列：先进先出First In First Out FIFO
 * 
 * 我们应该描述这样一个容器，给使用提供一个容器对象完成这两种结构。
 * 
 * @author sunjian
 *
 */







public class LinkedTest {

	public static void main(String[] args) {
		
		DuiLie duiLie = new DuiLie();
		
		duiLie.myAdd("abc1");
		duiLie.myAdd("abc2");
		duiLie.myAdd("abc3");
		duiLie.myAdd("abc4");

		while(!duiLie.isNull()){
			System.out.println(duiLie.myGet());
		}
		
		DuiZhan duiZhan = new DuiZhan();
		
		duiZhan.myAdd("football1");
		duiZhan.myAdd("football2");
		duiZhan.myAdd("football3");
		duiZhan.myAdd("football4");
		
		while(!duiZhan.isNull()){
			System.out.println(duiZhan.myGet());
		}
	}

}
