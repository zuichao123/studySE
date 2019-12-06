package cn.sunjian.threadsleep;
/**
 * Ҫ��
	���һ���̲߳����࣬Ҫ����Բ��������̶߳��󣬲����Էֱ����������̵߳�����ʱ�䣬������ʾ��
		1.�߳�A,����10��
		2.�߳�B,����20��
		3.�߳�C,����30��
	�ʣ�����������ƣ�
	
	ͨ����Runnable�ķ�����
	
 * @author sunjian
 *
 */
class MyThread2 implements Runnable{
	private String name;//�߳�����
	private int time;//ʱ������
	public MyThread2(String name,int time){
		this.name = name;//�����߳�����
		this.time = time;//��������ʱ��
	}
	//��дrun()����
	public void run(){
		try{
			Thread.sleep(this.time);//����ָ����ʱ��
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		System.out.println(this.name+"������"+this.time+"����");
	}
}


public class ThreadSleepDemo2 {

	public static void main(String[] args) {
		MyThread2 my1 = new MyThread2("�߳�A", 10000);
		MyThread2 my2 = new MyThread2("�߳�B", 20000);
		MyThread2 my3 = new MyThread2("�߳�C", 30000);
	
		new Thread(my1).start();
		new Thread(my2).start();
		new Thread(my3).start();//�����߳�
		
	}

}
