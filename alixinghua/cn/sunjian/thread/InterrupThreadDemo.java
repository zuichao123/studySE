package cn.sunjian.thread;
/**
 * 中断线程运行
 * 
 * @author jack
 *
 */

class MyThread6 implements Runnable{//实现Runnable接口
	public void run(){//覆写run方法
		System.out.println("1、进入run()方法");
		try {
			Thread.sleep(5000);//线程休眠5秒
			System.out.println("2、已经完成了休眠");
		} catch (InterruptedException e) {
			System.out.println("3、中断线程休眠");
			return;//返回被调用处
		}
		System.out.println("4、run()方法正常结束");
	}
}

public class InterrupThreadDemo {

	public static void main(String[] args) {

		MyThread6 mt = new MyThread6();//实例化Runnable子类对象
		
		Thread t = new Thread(mt, "线程");//实例化Thread对象
		
		t.start();//启动线程
		
		try {
			Thread.sleep(2000);//线程休眠2秒
		} catch (InterruptedException e) {
			System.out.println("3、休眠被终止");
		}
		t.interrupt();//中断线程执行
	
		
	}

}
