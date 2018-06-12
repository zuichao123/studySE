package cn.sunjian.thread;

/**
 * Runnable接口方式启动多线程
 * 
 * 实现资源共享
 * 
 * @author jack
 *
 */

class MyThread02 implements Runnable{
	private int titck = 5;//票数量
	
	public void run(){
		for (int i = 0; i < 10; i++) {
			if(this.titck>0)
				System.out.println("买票:"+this.titck--);
		}
	}
}

public class RunnableDemo2 {

	public static void main(String[] args) {

		MyThread02 mt1 = new MyThread02();//实例化对象
		
		Thread t1 = new Thread(mt1);//实例化Thread类对象
		Thread t2 = new Thread(mt1);
		Thread t3 = new Thread(mt1);
		
		t1.start();//启动线程
		t2.start();
		t3.start();
	}

}
