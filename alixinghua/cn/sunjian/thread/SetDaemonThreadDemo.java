package cn.sunjian.thread;
/**
 * 设置后台线程
 * 
 * @author jack
 *
 */

class MyThread7 implements Runnable{//实现Runnable接口
	public void run(){//覆写run方法
		while(true){
			System.out.println(Thread.currentThread().getName()+"在运行");
		}
	}
}

public class SetDaemonThreadDemo {

	public static void main(String[] args) {

		MyThread7 mt = new MyThread7();//实例化Runnable子类对象
		
		Thread t = new Thread(mt, "线程");//实例化Thread对象
		
		t.setDaemon(true);//此线程在后台运行
		
		t.start();//启动线程
		
	}

}
