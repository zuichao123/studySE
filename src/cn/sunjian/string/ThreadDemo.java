package cn.sunjian.string;

/**
 * ��ϰ���߳�
 * @author sunjian
 *
 */


class Demo1 extends Thread{
	private String name;
	
	Demo1(String name){
		//���ø���Ĺ��췽������name��ֵ���߳�
		super(name);
//		this.name = name;
	}
	
	public void run(){
		for(int x=0; x<10; x++){
			System.out.println(name+"...x...name="+x+Thread.currentThread().getName());
		}
	}
}
public class ThreadDemo {

	public static void main(String[] args) {
		Demo1 demo = new Demo1("����");
		Demo1 demo2 = new Demo1("xiaoqiang");
		//����Start��������run����
		demo.start();
		demo2.start();
		
		for(int x=0; x<10; x++){
			System.out.println("over...name="+Thread.currentThread().getName());
		}
	}

}
