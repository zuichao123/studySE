package cn.sunjian.string;

/**
 * 线程联系，面试题
 * @author sunjian
 *
 */

/*class Test implements Runnable{
	public void run(Thread thread){
		
	}
}*/

/**这个类的错误在第一行；
 * 因为，一个类如果实现了接口，如果没事覆盖（重写）接口中的方法时，
 * 此类必须定义为抽象类
 * @author sunjian
 *
 */



public class ThreadTest {

	public static void main(String[] args) {
	
		/*
		new Thread(){
			public void run(){				
				for(int x=0; x<50; x++){
					System.out.println(Thread.currentThread().getName()+"....x="+x);
				}
			}
		}.start();
		Runnable runnable = new Runnable(){
			public void run(){
				
				for(int x=0; x<50; x++){
					System.out.println(Thread.currentThread().getName()+"....y="+x);
				}
			}
		};
		new Thread(runnable).start();
				
			
		for(int x=0; x<50; x++){
			System.out.println(Thread.currentThread().getName()+"....z="+x);
		}*/
		
		子类方法优先();
		
	}

	/**
	 * 子类方法优先();
	 */
	private static void 子类方法优先() {
		new Thread(new Runnable() {
			
			@Override
			public void run() {//有任务时以任务为主
				System.out.println("runnable run");
			}
		}){
			public void run(){//有子类时以子类为主
				System.out.println("subThread run");
			}
		}.start();
	}

}
