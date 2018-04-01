package cn.sunjian.string;

import java.util.concurrent.locks.*;

/**
 * shengChanZhe,xiaoFeiZhe
 * @author sunjian
 *
 */

class Resource2{
	
	private String name;
	private int count = 1;
	private boolean flag = false;
	//创建一个锁对象
	Lock lock = new ReentrantLock();
	//通过已有的锁，获取两组监视器，一组监视生产者、一组监视消费者
	Condition Pro_con = lock.newCondition();
	Condition Con_con = lock.newCondition();
	
	public void set(String name){
		
		lock.lock();
		try {			
			while (flag) {
				try {
					Pro_con.await();
				} catch (InterruptedException e) {
					// TODO: handle exception
				}
			}
			this.name = name + count;
			count++;
			System.out.println(Thread.currentThread().getName()+".."+"生产者"+"..."+this.name);
			flag = true;
			Con_con.signal();
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			lock.unlock();
		}
	}
	
	public void out(){
		
		lock.lock();
		
		try {			
			while (!flag) {
				try {
					Con_con.await();
				} catch (InterruptedException e) {
					// TODO: handle exception
				}
			}
			System.out.println(Thread.currentThread().getName()+".."+"消费者"+"......"+this.name);
			flag = false;
			Pro_con.signal();
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			lock.unlock();
		}
	}
}


//shengchanzhe
class Producer implements Runnable{
	
	Resource2 r;
	
	Producer(Resource2 r) {
		this.r = r;
	}
	
	public void run(){
		while(true){
			r.set("kaoji");
		}
	}
}

//xiaofeizhe
class Consumer implements Runnable{
	
	Resource2 r;
	
	Consumer(Resource2 r){
		this.r = r;
	}
	
	public void run(){
		while(true){
			r.out();
		}
	}
}

public class ProducerConsumerDemo {

	public static void main(String[] args) {
		Resource2 r = new Resource2();
		
		Producer pro = new Producer(r);
		Consumer con = new Consumer(r);
		
		Thread t0 = new Thread(pro);
		Thread t1 = new Thread(pro);
		Thread t2 = new Thread(con);
		Thread t3 = new Thread(con);
		
		t0.start();
		t1.start();
		t2.start();
		t3.start();
		
	}

}
