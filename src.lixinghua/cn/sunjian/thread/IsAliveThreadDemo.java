package cn.sunjian.thread;
/**
 * ��ȡ�߳�����
 * 
 * @author jack
 *
 */

class MyThread4 implements Runnable{
	public void run(){
		for(int i=0;i<5;i++){			
			System.out.println(Thread.currentThread().getName()+"����"+i);
		}
	}
}

public class IsAliveThreadDemo {

	public static void main(String[] args) {

		MyThread4 mt = new MyThread4();//ʵ����Runnable�������
		
		Thread t = new Thread(mt, "�߳�");//ʵ����Thread����
		
		//�ж��Ƿ�����
		System.out.println("�߳̿�ʼִ��֮ǰ-->"+t.isAlive());
		
		t.start();//�����߳�
	
		//�ж��Ƿ�����
		System.out.println("�߳�ִ��֮��-->"+t.isAlive());
		
		for(int i=0; i<10;i++){
			System.out.println("main����-->"+i);
		}
		//�ж��Ƿ������������ȷ����
		System.out.println("����ִ��֮��-->"+t.isAlive());
		
	}

}
