package cn.sunjian.thread;

/**
 * Runnable接口方式启动多线程
 * 
 * @author jack
 *
 */

class MyThread2 implements Runnable{
	private String name;
	public MyThread2(String name){
		this.name = name;
	}
	
	public void run(){
		for (int i = 0; i < 10; i++) {
			System.out.println(this.name+":"+i);
		}
	}
}

public class RunnableDemo {

	public static void main(String[] args) {

		MyThread2 mt1 = new MyThread2("线程A");//实例化对象
		MyThread2 mt2 = new MyThread2("线程B");
		
		Thread t1 = new Thread(mt1);//实例化Thread类对象
		Thread t2 = new Thread(mt2);
		
		t1.start();//启动线程
		t2.start();
		
	}

}
