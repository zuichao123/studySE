package cn.sunjian.net_uploadtext;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class UploadServer {

	public static void main(String[] args) throws IOException {

		//1
		ServerSocket ss = new ServerSocket(10005);
		
		//2,
		Socket s = ss.accept();
		
		//3,
		BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
		
		//4,
		BufferedWriter bufw = new BufferedWriter(new FileWriter("E:\\server.txt"));
		
		String line = null;
		
		while((line=bufIn.readLine())!=null){
			
//			if ("over".equals(line))
//				break;
			
			bufw.write(line);
			bufw.newLine();
			bufw.flush();
			
		}
		
		PrintWriter out = new PrintWriter(s.getOutputStream(),true);
		out.println("�ϴ��ɹ���");
		
		//5,�ر���
		bufw.close();
		
		s.close();//�رտͻ���
		ss.close();//�رշ����
	}

}
