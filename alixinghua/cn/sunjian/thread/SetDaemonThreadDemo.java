package cn.sunjian.thread;
/**
 * ���ú�̨�߳�
 * 
 * @author jack
 *
 */

class MyThread7 implements Runnable{//ʵ��Runnable�ӿ�
	public void run(){//��дrun����
		while(true){
			System.out.println(Thread.currentThread().getName()+"������");
		}
	}
}

public class SetDaemonThreadDemo {

	public static void main(String[] args) {

		MyThread7 mt = new MyThread7();//ʵ����Runnable�������
		
		Thread t = new Thread(mt, "�߳�");//ʵ����Thread����
		
		t.setDaemon(true);//���߳��ں�̨����
		
		t.start();//�����߳�
		
	}

}
