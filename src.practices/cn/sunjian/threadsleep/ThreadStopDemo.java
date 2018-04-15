package cn.sunjian.threadsleep;

/**
 * 线程的停止操作
 * 	使用修改标志位的方式
 * 
 * @author sunjian
 *
 */
class MyThread7 implements Runnable{
	private boolean flag = true;//设置标志位，默认为true
	
	public void run(){
		int i = 0;
		while(this.flag){
			System.out.println(Thread.currentThread().getName()+"运行，i = "+i++);
		}
	}
	
	public void stop(){
		this.flag = false;
	}
}

public class ThreadStopDemo {

	public static void main(String[] args) {
		MyThread7 mt = new MyThread7();
		Thread t = new Thread(mt, "线程");//建立线程对象
		
		t.start();//启动线程
		try{
			Thread.sleep(50);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		
		mt.stop();//修改标志位，停止运行
	}

}
