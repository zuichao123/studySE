package cn.sunjian.thread;
/**
 * Thread���������߳�
 * 
 * �޷��ﵽ��Դ����
 * 
 * @author jack
 *
 */

class MyThread01 extends Thread{
	private int titck = 5;//Ʊ����

	public void run(){
		for(int i=0;i<10;i++){
			if (this.titck>0)
				System.out.println("��Ʊ��"+titck--);
		}
	}
	
}


public class ThreadDemo2 {

	public static void main(String[] args) {

		MyThread01 mt1 = new MyThread01();
		MyThread01 mt2 = new MyThread01();
		
		mt1.start();
		mt2.start();
	}

}
