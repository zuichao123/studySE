package cn.sunjian.threadsleep;
/**
 * Ҫ��
	���һ���̲߳����࣬Ҫ����Բ��������̶߳��󣬲����Էֱ����������̵߳�����ʱ�䣬������ʾ��
		1.�߳�A,����10��
		2.�߳�B,����20��
		3.�߳�C,����30��
	�ʣ�����������ƣ�
	
	ͨ����Thread��ķ�����
	
 * @author sunjian
 *
 */
class MyThread extends Thread{
	private int time;//ʱ������
	public MyThread(String name,int time){
		super(name);//�����߳�����
		this.time = time;//��������ʱ��
	}
	//��дrun()����
	public void run(){
		try{
			Thread.sleep(this.time);//����ָ����ʱ��
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"�̣߳�����"+this.time+"����");
	}
}


public class ThreadSleepDemo {

	public static void main(String[] args) {
		MyThread my1 = new MyThread("�߳�A", 10000);
		MyThread my2 = new MyThread("�߳�B", 20000);
		MyThread my3 = new MyThread("�߳�C", 30000);
	
		my1.start();
		my2.start();
		my3.start();//�����߳�
		
	}

}
