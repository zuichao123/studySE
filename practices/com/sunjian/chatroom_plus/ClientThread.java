package com.sunjian.chatroom_plus;

import java.io.BufferedReader;

public class ClientThread extends Thread {
	BufferedReader br = null;
	
	public ClientThread(BufferedReader br){
		this.br = br;
	}
}
