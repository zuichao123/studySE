package cn.sunjian.timertask;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * TimerTask类操作练习：
 * 	
 * 	需求：
 * 		完成一个定时调度的程序，每隔2秒打印一次时间
 * 
 * @author jack
 *
 */
class MyTask extends TimerTask{//任务调度都要继承TimerTask类
	
	//覆写run()方法
	public void run(){
		SimpleDateFormat sdf = null;
		
		sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
		
		System.out.println("当前系统时间："+sdf.format(new Date()));
	}
}

public class TimerTaskDemo {

	public static void main(String[] args) {

		Timer t = new Timer();//建立Timer类对象
		
		MyTask mt = new MyTask();//定义任务
		
		t.schedule(mt, 1000,2000);//设置定时任务，1秒后开始，然后每隔2秒执行一次
			
	}

}
