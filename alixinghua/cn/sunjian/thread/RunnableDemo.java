package cn.sunjian.thread;

/**
 * Runnable�ӿڷ�ʽ�������߳�
 * 
 * @author jack
 *
 */

class MyThread2 implements Runnable{
	private String name;
	public MyThread2(String name){
		this.name = name;
	}
	
	public void run(){
		for (int i = 0; i < 10; i++) {
			System.out.println(this.name+":"+i);
		}
	}
}

public class RunnableDemo {

	public static void main(String[] args) {

		MyThread2 mt1 = new MyThread2("�߳�A");//ʵ��������
		MyThread2 mt2 = new MyThread2("�߳�B");
		
		Thread t1 = new Thread(mt1);//ʵ����Thread�����
		Thread t2 = new Thread(mt2);
		
		t1.start();//�����߳�
		t2.start();
		
	}

}
