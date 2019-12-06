package cn.sunjian.thread;
/**
 * 设置线程的优先级
 * 
 * @author jack
 *
 */

class MyThread8 implements Runnable{//实现Runnable接口
	public void run(){//覆写run方法
		for(int i=0;i<5;i++){
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {}
				System.out.println(Thread.currentThread().getName()+"在运行"+i);
		}	
	}
}

public class PriorityThreadDemo {

	public static void main(String[] args) {
		
		Thread t1 = new Thread(new MyThread8(), "线程A");//实例化Thread对象
		Thread t2 = new Thread(new MyThread8(), "线程B");//实例化Thread对象
		Thread t3 = new Thread(new MyThread8(), "线程C");//实例化Thread对象
		
		t1.setPriority(Thread.MAX_PRIORITY);//设置最高优先级
		t2.setPriority(Thread.MIN_PRIORITY);//设置最低优先级
		t3.setPriority(Thread.NORM_PRIORITY);//设置普通优先级
		
		t1.start();//启动线程
		t2.start();//启动线程
		t3.start();//启动线程
		
	}

}
