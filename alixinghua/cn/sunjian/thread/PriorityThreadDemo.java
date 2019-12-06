package cn.sunjian.thread;
/**
 * �����̵߳����ȼ�
 * 
 * @author jack
 *
 */

class MyThread8 implements Runnable{//ʵ��Runnable�ӿ�
	public void run(){//��дrun����
		for(int i=0;i<5;i++){
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {}
				System.out.println(Thread.currentThread().getName()+"������"+i);
		}	
	}
}

public class PriorityThreadDemo {

	public static void main(String[] args) {
		
		Thread t1 = new Thread(new MyThread8(), "�߳�A");//ʵ����Thread����
		Thread t2 = new Thread(new MyThread8(), "�߳�B");//ʵ����Thread����
		Thread t3 = new Thread(new MyThread8(), "�߳�C");//ʵ����Thread����
		
		t1.setPriority(Thread.MAX_PRIORITY);//����������ȼ�
		t2.setPriority(Thread.MIN_PRIORITY);//����������ȼ�
		t3.setPriority(Thread.NORM_PRIORITY);//������ͨ���ȼ�
		
		t1.start();//�����߳�
		t2.start();//�����߳�
		t3.start();//�����߳�
		
	}

}
