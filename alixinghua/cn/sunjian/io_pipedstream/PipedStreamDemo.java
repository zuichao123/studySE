package cn.sunjian.io_pipedstream;
/**
 * �ܵ�����ϰ��
 * 	
 * 		ͨ���ܵ��������߳�
 * 
 * @author jack
 *
 */

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/*
 * �ܵ������
 */
class Send implements Runnable{//�߳���
	
	private PipedOutputStream pos = null;//�ܵ������
	public Send(){
		this.pos = new PipedOutputStream();
	}
	
	public void run(){
		String str = "hello world!";//Ҫ���������
		
		//ͨ���ܵ����������
		try {
			this.pos.write(str.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//�رչܵ���
		try {
			this.pos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	//�õ����̵߳Ĺܵ������
	public PipedOutputStream getPos(){
		return this.pos;
	}
}

/*
 * �ܵ�������
 */
class Receive implements Runnable{
	
	private PipedInputStream pis = null;//�ܵ�������
	public Receive(){
		this.pis = new PipedInputStream();
	}

	public void run(){
		byte[] b = new byte[1024];//��������
		int temp = 0;
		int len = 0;
		
		//��ȡ����
		try {
			while((temp = this.pis.read()) != -1){
				b[len] = (byte)temp;
				len++;
			}
			//len = this.pis.read(b);//�˾��ͬ������while����
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//�رչܵ���
		try {
			this.pis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("�������ݣ�"+new String(b,0,len));
	}
	
	//�õ����̵߳Ĺܵ�������
	public PipedInputStream getPis(){
		return this.pis;
	}
}

public class PipedStreamDemo {

	public static void main(String[] args) throws IOException {
		
		Send s = new Send();
		Receive r = new Receive();
		
		s.getPos().connect(r.getPis());//ͨ���ܵ�����������
		
		//�����߳�
		new Thread(s).start();
		new Thread(r).start();
		
	}

}
