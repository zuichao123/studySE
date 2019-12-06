package cn.sunjian.threadsleep;
/**
 * 多线程经典案例：
 * 		生产者和消费者
 * @author jack
 *
 */

/*
 * 定义信息类
 */
class Info{
	private String name = "李兴华";//定义name属性
	private String content = "JAVA讲师";//定义content属性
	private boolean flag = false;//设置标志位
	
	public void setName(String name){
		this.name = name;
	}
	public void setContent(String content){
		this.content = content;
	}
	public String getName(){
		return this.name;
	}
	public String getContent(){
		return this.content;
	}
	
	
	//定义set()方法，同步生产信息
	public synchronized void set(String name,String content){
		
		if (!flag) {
			try {
				super.wait();
			} catch (InterruptedException e) {	
				e.printStackTrace();
			}
		}
		
		this.setName(name);//设置姓名
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.setContent(content);//设置内容
		this.flag = false;//改变标志位
		super.notify();
	}
	//定义get()方法，同步消费信息
	public synchronized void get(){
		if (flag) {
			try {
				super.wait();
			} catch (InterruptedException e) {	
				e.printStackTrace();
			}
		}
		
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//输出生产的信息
		System.out.println(this.getName()+this.getContent());
		this.flag = true;
		super.notify();
	}
}

/*
 * 定义生产者类，实现Runnable接口
 */
class Producer implements Runnable{//通过Runnable实现多线程
	private Info info = null;//保存Info引用
	
	public Producer(Info info){//通过构造方法，设置info的属性
		this.info = info;
	}
	
	public void run(){//覆写run()方法
		boolean flag = false;//定义标记，默认false
		for(int i=0;i<50;i++){//生产50次信息
			if (flag) {
				info.set("李兴华","java讲师");
				flag = false;
			}else {
				info.set("孙健", "java学习者");
				flag = true;
			}
		}
	}	
}

/*
 * 消费者类，通过Runnable接口实现
 */
class Consumer implements Runnable{
	private Info info = null;
	public Consumer(Info info){
		this.info = info;
	}
	
	public void run(){
		for(int i=0;i<50;i++){
			info.get();
		}
	}
}


public class ProducersAndConsumers {

	public static void main(String[] args) {
		Info info = new Info();//实例化INFO对象
		
		Producer pro = new Producer(info);//生产者
		Consumer con = new Consumer(info);//消费者
		
		new Thread(pro).start();
		new Thread(con).start();
	}
}
