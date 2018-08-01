package com.sunjian.chatroom_plus;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

import javax.swing.JOptionPane;

/**
 * 客户端主类
 * 
 * 		增加了让用户输入用户名的代码，并且不允许用户名重复，
 * 		除此之外，开可以根据用户的键盘输入来判断用户是否想发送私聊信息。
 * 
 * @author jack
 *
 */
public class Client {

	private static final int SERVER_PORT = 30000;
	private Socket socket;
	private PrintStream ps;
	private BufferedReader brServer;
	private BufferedReader keyIn;
	
	public void init(){
		try {
			//初始化代表键盘的输入流
			keyIn = new BufferedReader(new InputStreamReader(System.in));
			//连接到服务器
			socket = new Socket("127.0.0.1", SERVER_PORT);
			//获取该Socket对应的输入流和输出流
			ps = new PrintStream(socket.getOutputStream());
			brServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			String tip = "";
			
			//采用循环不断的弹出对话框要求输入用户名
			while (true) {
				String userName = JOptionPane.showInputDialog(tip + "输入用户名");
				//在用户输入的用户名前后增加协议字符串后发送
				ps.println(CrazyitProtocol.USER_ROUND + userName + CrazyitProtocol.USER_ROUND);
				//读取服务器端的相应
				String result = brServer.readLine();
				//如果用户名重复，则开始下次循环
				if (result.equals(CrazyitProtocol.NAME_REP)) {
					tip = "用户名重复！请重新";
					continue;
				}
				//如果服务器端返回登录成功，则结束循环
				if (result.equals(CrazyitProtocol.LOGIN_SUCCESS)) {
					break;
				}
			}
		} catch (Exception e) {
			//捕获到异常，关闭网络资源，并推出改程序
			
			
			
			//.............
			
			
			
		}
	}
	
}
