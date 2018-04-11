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
				this.info.setName("李兴华");
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				this.info.setContent("JAVA讲师");
				flag = false;
			}else {
				this.info.setName("sunjian");
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				this.info.setContent("JAVA学习者");
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
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//输出生产的信息
			System.out.println(this.info.getName()+this.info.getContent());
		}
	}
}


public class ProducersAndConsumers {

	public static void main(String[] args) {
		Info info = new Info();
		
		Producer pro = new Producer(info);
		Consumer con = new Consumer(info);
		
		new Thread(pro).start();
		new Thread(con).start();
	}
}
