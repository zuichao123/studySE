package cn.sunjian.thread;
/**
 * ��ȡ�߳�����
 * 
 * @author jack
 *
 */

class MyThread3 implements Runnable{
	public void run(){
		for(int i=0;i<5;i++){			
			System.out.println(Thread.currentThread().getName()+"����"+i);
		}
	}
}

public class CurrentThreadDemo {

	public static void main(String[] args) {

		MyThread3 mt = new MyThread3();
		
		new Thread(mt).start();//ϵͳ�Զ������߳�����
		
		new Thread(mt, "�߳�A").start();//�ֶ������߳�����
		new Thread(mt, "�߳�B").start();
		
		mt.run();//main�����߳�
		
	}

}
