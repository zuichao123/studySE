package cn.sunjian.thread;
/**
 * ǿ���߳�����
 * 
 * @author jack
 *
 */

class MyThread5 implements Runnable{
	public void run(){
		for(int i=0;i<50;i++){			
			System.out.println(Thread.currentThread().getName()+"����"+i);//ȡ�õ�ǰ�̵߳�����
		}
	}
}

public class JoinThreadDemo {

	public static void main(String[] args) {

		MyThread5 mt = new MyThread5();//ʵ����Runnable�������
		
		Thread t = new Thread(mt, "�߳�");//ʵ����Thread����
		
		t.start();//�����߳�
	
		for(int i=0;i<50;i++){
			if (i>10) {
				try {
					t.join();//ǿ�����д��߳�
				} catch (InterruptedException e) {}
			}
			System.out.println("main�߳�����-->"+i);//���߳�
		}
	}

}
