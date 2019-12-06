package cn.sunjian.thread;
/**
 * 获取线程名称
 * 
 * @author jack
 *
 */

class MyThread3 implements Runnable{
	public void run(){
		for(int i=0;i<5;i++){			
			System.out.println(Thread.currentThread().getName()+"运行"+i);
		}
	}
}

public class CurrentThreadDemo {

	public static void main(String[] args) {

		MyThread3 mt = new MyThread3();
		
		new Thread(mt).start();//系统自动设置线程名称
		
		new Thread(mt, "线程A").start();//手动设置线程名称
		new Thread(mt, "线程B").start();
		
		mt.run();//main方法线程
		
	}

}
