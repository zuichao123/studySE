package cn.sunjian.threadsleep;

/**
 * �̵߳�ֹͣ����
 * 	ʹ���޸ı�־λ�ķ�ʽ
 * 
 * @author sunjian
 *
 */
class MyThread7 implements Runnable{
	private boolean flag = true;//���ñ�־λ��Ĭ��Ϊtrue
	
	public void run(){
		int i = 0;
		while(this.flag){
			System.out.println(Thread.currentThread().getName()+"���У�i = "+i++);
		}
	}
	
	public void stop(){
		this.flag = false;
	}
}

public class ThreadStopDemo {

	public static void main(String[] args) {
		MyThread7 mt = new MyThread7();
		Thread t = new Thread(mt, "�߳�");//�����̶߳���
		
		t.start();//�����߳�
		try{
			Thread.sleep(50);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		
		mt.stop();//�޸ı�־λ��ֹͣ����
	}

}
