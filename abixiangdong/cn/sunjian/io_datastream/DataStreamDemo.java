package cn.sunjian.io_datastream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataStreamDemo {

	public static void main(String[] args) throws IOException {

//		writeData();
		
		readData();
	}

	public static void readData() throws IOException {
		@SuppressWarnings("resource")
		DataInputStream dis = new DataInputStream(new FileInputStream("data.txt"));
		
		String str = dis.readUTF();
		
		System.out.println(str);
	}

	public static void writeData() throws IOException {
		
		DataOutputStream dos = new DataOutputStream(new FileOutputStream("data.txt"));
		
		dos.writeUTF("���");
		
		dos.close();
	}

}
