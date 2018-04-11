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
				this.info.setName("���˻�");
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				this.info.setContent("JAVA��ʦ");
				flag = false;
			}else {
				this.info.setName("sunjian");
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				this.info.setContent("JAVAѧϰ��");
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
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//�����������Ϣ
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
