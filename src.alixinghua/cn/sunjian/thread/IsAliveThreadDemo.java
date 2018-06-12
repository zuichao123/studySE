package cn.sunjian.thread;
/**
 * 获取线程名称
 * 
 * @author jack
 *
 */

class MyThread4 implements Runnable{
	public void run(){
		for(int i=0;i<5;i++){			
			System.out.println(Thread.currentThread().getName()+"运行"+i);
		}
	}
}

public class IsAliveThreadDemo {

	public static void main(String[] args) {

		MyThread4 mt = new MyThread4();//实例化Runnable子类对象
		
		Thread t = new Thread(mt, "线程");//实例化Thread对象
		
		//判断是否启动
		System.out.println("线程开始执行之前-->"+t.isAlive());
		
		t.start();//启动线程
	
		//判断是否启动
		System.out.println("线程执行之后-->"+t.isAlive());
		
		for(int i=0; i<10;i++){
			System.out.println("main运行-->"+i);
		}
		//判断是否启动（结果不确定）
		System.out.println("代码执行之后-->"+t.isAlive());
		
	}

}
