package cn.sunjian.string;

/**
 * �߳���ϵ��������
 * @author sunjian
 *
 */

/*class Test implements Runnable{
	public void run(Thread thread){
		
	}
}*/

/**�����Ĵ����ڵ�һ�У�
 * ��Ϊ��һ�������ʵ���˽ӿڣ����û�¸��ǣ���д���ӿ��еķ���ʱ��
 * ������붨��Ϊ������
 * @author sunjian
 *
 */



public class ThreadTest {

	public static void main(String[] args) {
	
		/*
		new Thread(){
			public void run(){				
				for(int x=0; x<50; x++){
					System.out.println(Thread.currentThread().getName()+"....x="+x);
				}
			}
		}.start();
		Runnable runnable = new Runnable(){
			public void run(){
				
				for(int x=0; x<50; x++){
					System.out.println(Thread.currentThread().getName()+"....y="+x);
				}
			}
		};
		new Thread(runnable).start();
				
			
		for(int x=0; x<50; x++){
			System.out.println(Thread.currentThread().getName()+"....z="+x);
		}*/
		
		���෽������();
		
	}

	/**
	 * ���෽������();
	 */
	private static void ���෽������() {
		new Thread(new Runnable() {
			
			@Override
			public void run() {//������ʱ������Ϊ��
				System.out.println("runnable run");
			}
		}){
			public void run(){//������ʱ������Ϊ��
				System.out.println("subThread run");
			}
		}.start();
	}

}
