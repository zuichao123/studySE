package cn.sunjian.thread;

/**
 * Runnable�ӿڷ�ʽ�������߳�
 * 
 * ʵ����Դ����
 * 
 * @author jack
 *
 */

class MyThread02 implements Runnable{
	private int titck = 5;//Ʊ����
	
	public void run(){
		for (int i = 0; i < 10; i++) {
			if(this.titck>0)
				System.out.println("��Ʊ:"+this.titck--);
		}
	}
}

public class RunnableDemo2 {

	public static void main(String[] args) {

		MyThread02 mt1 = new MyThread02();//ʵ��������
		
		Thread t1 = new Thread(mt1);//ʵ����Thread�����
		Thread t2 = new Thread(mt1);
		Thread t3 = new Thread(mt1);
		
		t1.start();//�����߳�
		t2.start();
		t3.start();
	}

}
