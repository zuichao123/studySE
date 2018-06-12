package cn.sunjian.io_piped;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipedStream {

	public static void main(String[] args) throws IOException {
		
		PipedInputStream input = new PipedInputStream();
		PipedOutputStream output = new PipedOutputStream();
		
		//������
		input.connect(output);
		
		//���̲߳������������׳�������
		
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
			//��ӡs
			System.out.println("s="+s);
			//�ر���
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
			out.write("hi, �ܵ����ˣ�".getBytes());
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}