package cn.sunjian.threadsleep;
/**
 * 要求：
	设计一个线程操作类，要求可以产生三个线程对象，并可以分别设置三个线程的休眠时间，如下所示：
		1.线程A,休眠10秒
		2.线程B,休眠20秒
		3.线程C,休眠30秒
	问：此类该如何设计？
	
	通过：Thread类的方法。
	
 * @author sunjian
 *
 */
class MyThread extends Thread{
	private int time;//时间属性
	public MyThread(String name,int time){
		super(name);//设置线程名称
		this.time = time;//设置休眠时间
	}
	//覆写run()方法
	public void run(){
		try{
			Thread.sleep(this.time);//休眠指定的时间
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"线程，休眠"+this.time+"毫秒");
	}
}


public class ThreadSleepDemo {

	public static void main(String[] args) {
		MyThread my1 = new MyThread("线程A", 10000);
		MyThread my2 = new MyThread("线程B", 20000);
		MyThread my3 = new MyThread("线程C", 30000);
	
		my1.start();
		my2.start();
		my3.start();//启动线程
		
	}

}
