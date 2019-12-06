package cn.sunjian.thread;
/**
 * �ж��߳�����
 * 
 * @author jack
 *
 */

class MyThread6 implements Runnable{//ʵ��Runnable�ӿ�
	public void run(){//��дrun����
		System.out.println("1������run()����");
		try {
			Thread.sleep(5000);//�߳�����5��
			System.out.println("2���Ѿ����������");
		} catch (InterruptedException e) {
			System.out.println("3���ж��߳�����");
			return;//���ر����ô�
		}
		System.out.println("4��run()������������");
	}
}

public class InterrupThreadDemo {

	public static void main(String[] args) {

		MyThread6 mt = new MyThread6();//ʵ����Runnable�������
		
		Thread t = new Thread(mt, "�߳�");//ʵ����Thread����
		
		t.start();//�����߳�
		
		try {
			Thread.sleep(2000);//�߳�����2��
		} catch (InterruptedException e) {
			System.out.println("3�����߱���ֹ");
		}
		t.interrupt();//�ж��߳�ִ��
	
		
	}

}
