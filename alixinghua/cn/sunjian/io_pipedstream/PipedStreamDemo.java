package cn.sunjian.io_pipedstream;
/**
 * 管道流练习：
 * 	
 * 		通过管道流连接线程
 * 
 * @author jack
 *
 */

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/*
 * 管道输出流
 */
class Send implements Runnable{//线程类
	
	private PipedOutputStream pos = null;//管道输出流
	public Send(){
		this.pos = new PipedOutputStream();
	}
	
	public void run(){
		String str = "hello world!";//要输出的内容
		
		//通过管道流输出内容
		try {
			this.pos.write(str.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//关闭管道流
		try {
			this.pos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	//得到此线程的管道输出流
	public PipedOutputStream getPos(){
		return this.pos;
	}
}

/*
 * 管道输入流
 */
class Receive implements Runnable{
	
	private PipedInputStream pis = null;//管道输入流
	public Receive(){
		this.pis = new PipedInputStream();
	}

	public void run(){
		byte[] b = new byte[1024];//接收内容
		int temp = 0;
		int len = 0;
		
		//读取内容
		try {
			while((temp = this.pis.read()) != -1){
				b[len] = (byte)temp;
				len++;
			}
			//len = this.pis.read(b);//此句等同于以上while语句块
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//关闭管道流
		try {
			this.pis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("接收内容："+new String(b,0,len));
	}
	
	//得到此线程的管道输入流
	public PipedInputStream getPis(){
		return this.pis;
	}
}

public class PipedStreamDemo {

	public static void main(String[] args) throws IOException {
		
		Send s = new Send();
		Receive r = new Receive();
		
		s.getPos().connect(r.getPis());//通过管道流关联起来
		
		//启动线程
		new Thread(s).start();
		new Thread(r).start();
		
	}

}
