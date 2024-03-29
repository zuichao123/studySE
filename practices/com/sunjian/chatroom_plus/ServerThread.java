package com.sunjian.chatroom_plus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * 服务器端线程类：
 * 		分别处理公聊、私聊两类聊天信息
 * 		处理用户名是否重复的问题
 * 
 * 		本程序除了增加了异常处理之外，还增加了对读取数据的判断，程序读到客户端发送过来的内容之后，会根据该内容的协议字符城对该内容进行相应的处理。
 * 	
 * @author jack
 *
 */
public class ServerThread extends Thread {
	private Socket socket;
	BufferedReader br = null;
	PrintStream ps = null;
	
	//定义一个构造器，用于接收一个Socket来创建ServerThread线程
	public ServerThread(Socket socket){
		this.socket = socket;
	}
	
	public void run(){
		try {
			//获取该Socket对应的输入流
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			//获取该Socket对应的输出流
			ps = new PrintStream(socket.getOutputStream());
			String line = null;
			while((line = br.readLine()) != null){
				//如果读到的行以CrazyitProtocol.USER_ROUND开始，并以其结束；则可以确定读到的用户登录的用户名
				if(line.startsWith(CrazyitProtocol.USER_ROUND) && line.endsWith(CrazyitProtocol.USER_ROUND)){
					//得到真实信息
					String userName = getRealMsg(line);
					//如果用户名重复
					if(Server.clients.containsKey(userName)){
						System.out.println("重复");
						ps.println(CrazyitProtocol.NAME_REP);
					}else {
						System.out.print("成功");
						ps.println(CrazyitProtocol.LOGIN_SUCCESS);
						Server.clients.put(userName, ps);
					}
				}else if(line.startsWith(CrazyitProtocol.PRIVATE_ROUND) && line.endsWith(CrazyitProtocol.PRIVATE_ROUND)){
					//如果读到的行以CrazyitProtocol.PRIVATE_ROUND开始，并以其结束；则可以确定时私聊信息，私聊信息只向特定的输出流发送
						
						//得到真实信息
						String userAndMsg = getRealMsg(line);
						//以SPLIT_SIGN分隔字符串，前半是私聊用户，后半是聊天信息
						String user = userAndMsg.split(CrazyitProtocol.SPLIT_SIGN)[0];
						String msg = userAndMsg.split(CrazyitProtocol.SPLIT_SIGN)[1];
						//获取私聊用户对应的输出流，并发送私聊信息
						Server.clients.get(user).println(Server.clients.getKeyByValue(ps) + "悄悄对你说："+msg);
					}else {//公聊要向每个Socket发送
						//得到真实信息
						String msg = getRealMsg(line);
						//遍历clients中的每个输出流
						for(PrintStream clientPs : Server.clients.valueSet()){
							clientPs.println(Server.clients.getKeyByValue(ps)+"说："+msg);
						}
					}
				}
			
			} catch (IOException e) {//捕获到异常后，表明该Socket对应的客户端已经出现了问题；所以程序将其对应的输出流从map中删除
				Server.clients.removeByValue(ps);
				System.out.println(Server.clients.size());
				//关闭网络、IO资源
				try {
					if (br != null) {
						br.close();
					}
					if(ps != null){
						ps.close();
					}
					if(socket != null){
						socket.close();
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
	}

	//将读到的内容去掉前后的协议字符，恢复成真实数据
	private String getRealMsg(String line) {
		
		return line.substring(CrazyitProtocol.PROTOCOL_LEN,line.length() - CrazyitProtocol.PROTOCOL_LEN);
	}
}
