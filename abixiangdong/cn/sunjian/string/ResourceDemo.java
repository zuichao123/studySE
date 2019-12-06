package cn.sunjian.string;

/**
 * �̼߳��ͨѶ
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
					r.name = "����";
					r.sex = "ŮŮŮ";
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
		//������Դ
		Resource resource = new Resource();
		//��������
		Input input = new Input(resource);
		Output output = new Output(resource);
		//�����߳�
		Thread t1 = new Thread(input);
		Thread t2 = new Thread(output);
		//�����߳�
		t1.start();
		t2.start();
		
	}

}
