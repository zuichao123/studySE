package cn.sunjian.io_sequence;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;


public class SequenceInputStreamDemo {

	public static void main(String[] args) throws IOException {

		/**
		 * ���󣺽�1.tex 2.txt 3.txt���ļ��е����ݺϲ���ͬһ���ļ���
		 * 
		 * ��ȷ��Դ�����ı�����ý�壩����������ֽ���
		 * 
		 */
		
		//ö��
//		Vector<FileInputStream> v = new Vector<FileInputStream>();
//		
//		v.add(new FileInputStream("1.txt"));//���������
//		v.add(new FileInputStream("2.txt"));
//		v.add(new FileInputStream("3.txt"));
//		v.add(new FileInputStream("4.txt"));
		
		ArrayList<FileInputStream> al = new ArrayList<FileInputStream>();//Ч�ʸߣ�����û��ö�٣�ֻ���Լ�ȥnewö�ٶ���
		for(int x=1; x<=5; x++){
			al.add(new FileInputStream(x+".txt"));
		}
		
		Enumeration<FileInputStream> en = Collections.enumeration(al);
		
		SequenceInputStream sis = new SequenceInputStream(en);//newһ����������������ߴ�һ��ö�����͵Ĳ����������Դ�ϲ�Ϊһ��Դ
		
		FileOutputStream fos = new FileOutputStream("6.txt");//�Զ���һ��������6.txt
		
		byte[] buf = new byte[1024];//��������СΪ1024kb
		
		int len = 0;
		
		//ѭ����ȡԴ�е����ݣ���д�뵽��������
		while((len=sis.read(buf))!=-1){
			fos.write(buf,0,len);
		}
		
		//�ر���
		fos.close();
		sis.close();
		
	}

}
