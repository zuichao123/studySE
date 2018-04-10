package cn.sunjian.thread;
/**
 * 
 * 线程的同步：
 * 		同步代码块方式
 * 		
 * 
 * @author sunjian
 *
 */
class MyThread001  implements Runnable{
	private int ticket = 5;//假设有5张票
	public void run(){//覆写run()方法
		for(int i=0;i<100;i++){
			synchronized (this) {//对当前对象加锁
				
				if (ticket>0) {
					try{
						Thread.sleep(300);//加入延时
					}catch(InterruptedException e){
						e.printStackTrace();
					}
					System.out.println("买票：ticket = " + ticket--);
				}			
			}
		}
		System.out.println("票卖完了。。。");
	}
}


public class SyncLockThreadDemo {

	public static void main(String[] args) {
		MyThread001 mt1 = new MyThread001();//定义线程对象
		
		Thread t1 = new Thread(mt1);//定义Thread对象
		Thread t2 = new Thread(mt1);//定义Thread对象
		Thread t3 = new Thread(mt1);//定义Thread对象
		
		t1.start();//启动线程
		t2.start();
		t3.start();
	}

}
