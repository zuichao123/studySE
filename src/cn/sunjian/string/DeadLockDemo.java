package cn.sunjian.string;

/**
 * 写一个死锁的程序
 * @author sunjian
 *
 */


class Demo implements Runnable{
	boolean flag = false;
	
//	public Demo(boolean flag) {
//		this.flag = flag;
//	}
	
	public void run(){
		if (flag) {
			synchronized (MyLock.locka) {
				System.out.println(Thread.currentThread().getName()+"..if..locka");
				synchronized (MyLock.lockb) {
					System.out.println(Thread.currentThread().getName()+"..if..lockb");
				}
			}
		}else {
			synchronized (MyLock.lockb) {
				System.out.println(Thread.currentThread().getName()+"..if..lockb");
				synchronized (MyLock.locka) {
					System.out.println(Thread.currentThread().getName()+"..if..lockb");
				}
			}
		}
	}
}

class MyLock{
	//定义两个对象锁
	static final Object locka = new Object();
	static final Object lockb = new Object();
}

public class DeadLockDemo {

	public static void main(String[] args) {
//		Demo demo = new Demo(true);
//		Demo demo2 = new Demo(false);
		Demo demo2 = new Demo();
		
		Thread t1 = new Thread(demo2);
		Thread t2 = new Thread(demo2);
		
		t1.start();
		try {
			Thread.sleep(10);
		} catch ( InterruptedException e) {
			// TODO: handle exception
		}
		demo2.flag = true;
		t2.start();
	}

}
