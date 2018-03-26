package cn.sunjian.net.uploadtext;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class UploadClient {

	public static void main(String[] args) throws UnknownHostException, IOException {

		//1
		Socket s = new Socket("10.2.1.96",10005);
		
		//2
		BufferedReader bufr = new BufferedReader(new FileReader("E:\\client.txt"));
		
		//3
		PrintWriter out = new PrintWriter(s.getOutputStream(),true);
		
		String line= null;
		while((line=bufr.readLine())!=null){
			
			out.println(line);
		}
		
		//告诉服务端，客户端写完了
		s.shutdownOutput();
//		out.println("over");
		
		//4,读取Socket流
		BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
		
		String str = bufIn.readLine();
		System.out.println(str);
		
		//5,关闭流
		bufr.close();
		s.close();
		
	}

}
