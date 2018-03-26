package cn.sunjian.string;

/**
 * 线程间的通讯--等待唤醒机制--代码优化
 * @author sunjian
 *
 */

class Resource1{
	private String name;
	private String sex;
	private boolean flag = false;
	
	public synchronized void set(String name, String sex){
		
		if (flag) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		this.name = name;
		this.sex = sex;
		this.flag = true;
		this.notify();
	}
	
	public synchronized void out(){
		if (!flag) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		System.out.println(name+"...+..."+sex);
		this.flag = false;
		this.notify();
	}
}

//input
class Input1 implements Runnable{
	
	Resource1 r;
	public Input1(Resource1 r){
		this.r = r;
	}
	
	public void run(){
		
		int x = 0;
		
		while(true){
			if (x==0) {
				r.set("mike", "man");
			}else {
				r.set("静静", "女女女女");
			}
			x = (x+1)%2;
		}
	}
}

//output
class Output1 implements Runnable{
	
	Resource1 r;
	public Output1(Resource1 r) {
		this.r = r;
	}
	
	public void run(){
		
		while(true){
			r.out();
		}
	}
}


public class ResourceDemo1 {

	public static void main(String[] args) {
		//创建资源
		Resource1 resource = new Resource1();
		//创建任务
		Input1 input = new Input1(resource);
		Output1 output = new Output1(resource);
		//创建线程
		Thread t1 = new Thread(input);
		Thread t2 = new Thread(output);
		//启动线程
		t1.start();
		t2.start();
	}

}
