package cn.sunjian.thread;
/**
 * 
 * �̵߳�ͬ����
 * 		ͬ�������ķ�ʽ
 * 		
 * 
 * @author sunjian
 *
 */
class MyThread002  implements Runnable{
	private int ticket = 5;//������5��Ʊ
	public void run(){//��дrun()����
		for(int i=0;i<100;i++){
			this.sale();//����ͬ����Ʊ����
		}
		System.out.println("Ʊ�����ˡ�����");
	}
	
	//������Ʊ����
	public synchronized void sale(){//����ͬ������
		if (ticket>0) {//����Ʊ
			try{
				Thread.sleep(300);//������ʱ
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			System.out.println("��Ʊ��ticket = " + ticket--);
		}	
	}
	
}


public class SyncLockThreadDemo2 {

	public static void main(String[] args) {
		MyThread002 mt1 = new MyThread002();//�����̶߳���
		
		Thread t1 = new Thread(mt1);//����Thread����
		Thread t2 = new Thread(mt1);//����Thread����
		Thread t3 = new Thread(mt1);//����Thread����
		
		t1.start();//�����߳�
		t2.start();
		t3.start();
	}

}
