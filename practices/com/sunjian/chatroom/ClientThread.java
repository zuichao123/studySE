package com.sunjian.chatroom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * ClientThread负责读取Socket对应输入流中的数据（从服务器端发送过来的数据），并将这些数据打印输出；
 * 
 * 
 * @author jack
 *
 */
public class ClientThread implements Runnable {
	
	//该线程负责处理的Socket
	private Socket s;
	//该线程所处理的Socket对应的输入流；
	BufferedReader br = null;
	
	public ClientThread(Socket s) throws IOException {
		this.s = s;
		this.br = new BufferedReader(new InputStreamReader(s.getInputStream()));
	}

	@Override
	public void run() {
		try {
			String content = null;
			//不断读取Socket输入流中的内容，并将这些内容打印输出
			while((content = br.readLine()) != null){
				System.out.println(content);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
