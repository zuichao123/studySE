package cn.sunjian.thread;
/**
 * 强制线程运行
 * 
 * @author jack
 *
 */

class MyThread5 implements Runnable{
	public void run(){
		for(int i=0;i<50;i++){			
			System.out.println(Thread.currentThread().getName()+"运行"+i);//取得当前线程的名字
		}
	}
}

public class JoinThreadDemo {

	public static void main(String[] args) {

		MyThread5 mt = new MyThread5();//实例化Runnable子类对象
		
		Thread t = new Thread(mt, "线程");//实例化Thread对象
		
		t.start();//启动线程
	
		for(int i=0;i<50;i++){
			if (i>10) {
				try {
					t.join();//强制运行此线程
				} catch (InterruptedException e) {}
			}
			System.out.println("main线程运行-->"+i);//主线程
		}
	}

}
