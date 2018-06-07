package cn.sunjian.net_uploadpic;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class UploadPicServer {

	public static void main(String[] args) throws IOException {

		//����tcp��Socket�����
		ServerSocket ss = new ServerSocket(10006);
		
		while(true){
			
			Socket s = ss.accept();
			
			new Thread(new UploadTask(s)).start();
			
			ss.close();
			
		}
		
		
		
		
	}

}
