package cn.sunjian.thread;
/**
 * 线程的礼让
 * 
 * @author jack
 *
 */

class MyThread9 implements Runnable{//实现Runnable接口
	public void run(){//覆写run方法
		for(int i=0;i<5;i++){
			try {
				Thread.sleep(500);
			} catch (Exception e) {}
			//取得当前线程的名字
			System.out.println(Thread.currentThread().getName()+"运行, i = "+i);
			if (i==2) {
				System.out.print("线程礼让：");
				Thread.currentThread();
				Thread.yield();//线程礼让
			}
		}
	}
}

public class YieldThreadDemo {

	public static void main(String[] args) {
		MyThread9 my = new MyThread9();//实例化MyThread对象
		
		Thread t1 = new Thread(my,"线程A");
		Thread t2 = new Thread(my,"线程B");
		
		t1.start();//启动线程
		t2.start();//启动线程
		
		
		
		
	}

}
