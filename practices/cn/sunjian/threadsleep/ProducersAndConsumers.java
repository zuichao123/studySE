package cn.sunjian.threadsleep;
/**
 * ���߳̾��䰸����
 * 		�����ߺ�������
 * @author jack
 *
 */

/*
 * ������Ϣ��
 */
class Info{
	private String name = "���˻�";//����name����
	private String content = "JAVA��ʦ";//����content����
	private boolean flag = false;//���ñ�־λ
	
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
	
	
	//����set()������ͬ��������Ϣ
	public synchronized void set(String name,String content){
		
		if (!flag) {
			try {
				super.wait();
			} catch (InterruptedException e) {	
				e.printStackTrace();
			}
		}
		
		this.setName(name);//��������
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.setContent(content);//��������
		this.flag = false;//�ı��־λ
		super.notify();
	}
	//����get()������ͬ��������Ϣ
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
		//�����������Ϣ
		System.out.println(this.getName()+this.getContent());
		this.flag = true;
		super.notify();
	}
}

/*
 * �����������࣬ʵ��Runnable�ӿ�
 */
class Producer implements Runnable{//ͨ��Runnableʵ�ֶ��߳�
	private Info info = null;//����Info����
	
	public Producer(Info info){//ͨ�����췽��������info������
		this.info = info;
	}
	
	public void run(){//��дrun()����
		boolean flag = false;//�����ǣ�Ĭ��false
		for(int i=0;i<50;i++){//����50����Ϣ
			if (flag) {
				info.set("���˻�","java��ʦ");
				flag = false;
			}else {
				info.set("�｡", "javaѧϰ��");
				flag = true;
			}
		}
	}	
}

/*
 * �������࣬ͨ��Runnable�ӿ�ʵ��
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
		Info info = new Info();//ʵ����INFO����
		
		Producer pro = new Producer(info);//������
		Consumer con = new Consumer(info);//������
		
		new Thread(pro).start();
		new Thread(con).start();
	}
}
