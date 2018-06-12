package cn.sunjian.timertask;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * TimerTask�������ϰ��
 * 	
 * 	����
 * 		���һ����ʱ���ȵĳ���ÿ��2���ӡһ��ʱ��
 * 
 * @author jack
 *
 */
class MyTask extends TimerTask{//������ȶ�Ҫ�̳�TimerTask��
	
	//��дrun()����
	public void run(){
		SimpleDateFormat sdf = null;
		
		sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
		
		System.out.println("��ǰϵͳʱ�䣺"+sdf.format(new Date()));
	}
}

public class TimerTaskDemo {

	public static void main(String[] args) {

		Timer t = new Timer();//����Timer�����
		
		MyTask mt = new MyTask();//��������
		
		t.schedule(mt, 1000,2000);//���ö�ʱ����1���ʼ��Ȼ��ÿ��2��ִ��һ��
			
	}

}
