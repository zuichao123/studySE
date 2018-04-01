package cn.sunjian.string;

/**
 * 练习多线程
 * @author sunjian
 *
 */


class Demo1 extends Thread{
	private String name;
	
	Demo1(String name){
		//调用父类的构造方法，将name赋值给线程
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
		Demo1 demo = new Demo1("旺财");
		Demo1 demo2 = new Demo1("xiaoqiang");
		//调用Start方法调用run方法
		demo.start();
		demo2.start();
		
		for(int x=0; x<10; x++){
			System.out.println("over...name="+Thread.currentThread().getName());
		}
	}

}
