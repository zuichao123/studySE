package cn.sunjian.string;

/**
 * 线程间的通讯
 * @author sunjian
 *
 */

/*
 * 
 */

class Resource{
	String name;
	String sex;
	boolean flag = false;
}

class Input implements Runnable{
	Resource r;
	int x = 0;
	public Input(Resource r){
		this.r = r;
	}
	public void run(){
		while(true){
			synchronized(r){	
				if (r.flag){		
					try {
						r.wait();
					} catch (Exception e) {
						// TODO: handle exception
					}
				} 
				if (x==0) {
					r.name = "mike";
					r.sex = "man";
				}else {
					r.name = "静静";
					r.sex = "女女女";
				}				
				r.flag = true;
				r.notify();
			}
			x = (x+1)%2;
		}
	}
}

class Output implements Runnable{
	
	Resource r;
	public Output(Resource r) {
		this.r = r;
	}
	public void run(){
		while(true){
			synchronized(r){
				if (!r.flag){		
					try {
						r.wait();
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
				System.out.println(r.name+"..."+r.sex);
				r.flag = false;
				r.notify();
			}
		}
	}
}

public class ResourceDemo {

	public static void main(String[] args) {
		//创建资源
		Resource resource = new Resource();
		//创建任务
		Input input = new Input(resource);
		Output output = new Output(resource);
		//创建线程
		Thread t1 = new Thread(input);
		Thread t2 = new Thread(output);
		//启动线程
		t1.start();
		t2.start();
		
	}

}
