package cn.sunjian.thread;
/**
 * 
 * �̵߳�ͬ����
 * 		ͬ������鷽ʽ
 * 		
 * 
 * @author sunjian
 *
 */
class MyThread001  implements Runnable{
	private int ticket = 5;//������5��Ʊ
	public void run(){//��дrun()����
		for(int i=0;i<100;i++){
			synchronized (this) {//�Ե�ǰ�������
				
				if (ticket>0) {
					try{
						Thread.sleep(300);//������ʱ
					}catch(InterruptedException e){
						e.printStackTrace();
					}
					System.out.println("��Ʊ��ticket = " + ticket--);
				}			
			}
		}
		System.out.println("Ʊ�����ˡ�����");
	}
}


public class SyncLockThreadDemo {

	public static void main(String[] args) {
		MyThread001 mt1 = new MyThread001();//�����̶߳���
		
		Thread t1 = new Thread(mt1);//����Thread����
		Thread t2 = new Thread(mt1);//����Thread����
		Thread t3 = new Thread(mt1);//����Thread����
		
		t1.start();//�����߳�
		t2.start();
		t3.start();
	}

}
