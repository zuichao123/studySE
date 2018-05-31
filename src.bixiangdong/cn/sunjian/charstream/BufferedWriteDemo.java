package cn.sunjian.charstream;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriteDemo {

	public static void main(String[] args) throws IOException {

		FileWriter fw = new FileWriter("buf.txt");
	
		//Ϊ�����д���Ч�ʣ�ʹ�����ַ����Ļ�������
		//������һ���ַ�д�����Ļ��������󣬲���ָ��Ҫ��������������������
		BufferedWriter bufw = new BufferedWriter(fw);
		
		//ʹ�û�������д�뷽����������д�뵽�������С�
		for (int i = 0; i < 5; i++) {			
			bufw.write("abcdefghijklmn");
			bufw.newLine();
		}
		
		//ʹ�û�������ˢ�·���������ˢ�µ�Ŀ�ĵ��С�
		bufw.flush();
		
		//�رջ�����
		bufw.close();
		
	}

}
