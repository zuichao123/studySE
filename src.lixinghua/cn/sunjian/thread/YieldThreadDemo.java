package cn.sunjian.thread;
/**
 * �̵߳�����
 * 
 * @author jack
 *
 */

class MyThread9 implements Runnable{//ʵ��Runnable�ӿ�
	public void run(){//��дrun����
		for(int i=0;i<5;i++){
			try {
				Thread.sleep(500);
			} catch (Exception e) {}
			//ȡ�õ�ǰ�̵߳�����
			System.out.println(Thread.currentThread().getName()+"����, i = "+i);
			if (i==2) {
				System.out.print("�߳����ã�");
				Thread.currentThread();
				Thread.yield();//�߳�����
			}
		}
	}
}

public class YieldThreadDemo {

	public static void main(String[] args) {
		MyThread9 my = new MyThread9();//ʵ����MyThread����
		
		Thread t1 = new Thread(my,"�߳�A");
		Thread t2 = new Thread(my,"�߳�B");
		
		t1.start();//�����߳�
		t2.start();//�����߳�
		
		
		
		
	}

}
