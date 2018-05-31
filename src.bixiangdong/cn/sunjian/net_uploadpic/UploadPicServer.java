package cn.sunjian.net_uploadpic;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class UploadPicServer {

	public static void main(String[] args) throws IOException {

		//创建tcp的Socket服务端
		ServerSocket ss = new ServerSocket(10006);
		
		while(true){
			
			Socket s = ss.accept();
			
			new Thread(new UploadTask(s)).start();
			
			ss.close();
			
		}
		
		
		
		
	}

}
