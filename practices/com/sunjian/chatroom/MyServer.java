package com.sunjian.chatroom;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
/**
 * 服务端
 * ServerSocket监听的主类
 * 
 * @author jack
 *
 */
public class MyServer {
	//定义保存所有Socket的ArrayList
	public static ArrayList<Socket> socketList = new ArrayList<>();
	
	@SuppressWarnings("resource")
	public static void main(String[] args)throws IOException{
		
		ServerSocket ss = new ServerSocket(30000);
		while(true){
			//此行代码会阻塞，将一直等待别人的连接
			Socket s = ss.accept();
			socketList.add(s);
			//每当客户端连接后启动一个ServerThread线程为该客户端服务
			new Thread(new ServerThread(s)).start();
		}
	}
}
