package cn.sunjian.thread;
/**
 * Thread类启动多线程
 * 
 * 无法达到资源共享
 * 
 * @author jack
 *
 */

class MyThread01 extends Thread{
	private int titck = 5;//票数量

	public void run(){
		for(int i=0;i<10;i++){
			if (this.titck>0)
				System.out.println("买票："+titck--);
		}
	}
	
}


public class ThreadDemo2 {

	public static void main(String[] args) {

		MyThread01 mt1 = new MyThread01();
		MyThread01 mt2 = new MyThread01();
		
		mt1.start();
		mt2.start();
	}

}
