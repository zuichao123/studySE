package cn.sunjian.io_piped;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipedStream {

	public static void main(String[] args) throws IOException {
		
		PipedInputStream input = new PipedInputStream();
		PipedOutputStream output = new PipedOutputStream();
		
		//连接流
		input.connect(output);
		
		//多线程操作，否则容易出现死锁
		
		new Thread(new Input(input)).start();
		new Thread(new Ouput(output)).start();

	}

}


class Input implements Runnable{
	
	private PipedInputStream in;
	
	public Input(PipedInputStream in) {
		this.in = in;
	}
	
	public void run(){
		try{
			byte[] buf = new byte[1024];
			int len = in.read(buf);
			
			String s = new String(buf, 0, len);
			//打印s
			System.out.println("s="+s);
			//关闭流
			in.close();
		}catch(Exception exception){
			
		}
		
	}
}



class Ouput implements Runnable{
	
	private PipedOutputStream out;
	
	public Ouput(PipedOutputStream out) {
		this.out = out;
	}
	
	public void run(){
		try {
			out.write("hi, 管道来了！".getBytes());
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}