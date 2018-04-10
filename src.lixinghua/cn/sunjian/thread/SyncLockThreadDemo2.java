package cn.sunjian.thread;
/**
 * 
 * 线程的同步：
 * 		同步方法的方式
 * 		
 * 
 * @author sunjian
 *
 */
class MyThread002  implements Runnable{
	private int ticket = 5;//假设有5张票
	public void run(){//覆写run()方法
		for(int i=0;i<100;i++){
			this.sale();//调用同步买票方法
		}
		System.out.println("票卖完了。。。");
	}
	
	//增加卖票方法
	public synchronized void sale(){//声明同步方法
		if (ticket>0) {//还有票
			try{
				Thread.sleep(300);//加入延时
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			System.out.println("买票：ticket = " + ticket--);
		}	
	}
	
}


public class SyncLockThreadDemo2 {

	public static void main(String[] args) {
		MyThread002 mt1 = new MyThread002();//定义线程对象
		
		Thread t1 = new Thread(mt1);//定义Thread对象
		Thread t2 = new Thread(mt1);//定义Thread对象
		Thread t3 = new Thread(mt1);//定义Thread对象
		
		t1.start();//启动线程
		t2.start();
		t3.start();
	}

}
