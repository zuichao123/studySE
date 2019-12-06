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
		 * 需求：将1.tex 2.txt 3.txt等文件中的数据合并到同一个文件中
		 * 
		 * 不确定源（是文本还是媒体）的情况下用字节流
		 * 
		 */
		
		//枚举
//		Vector<FileInputStream> v = new Vector<FileInputStream>();
//		
//		v.add(new FileInputStream("1.txt"));//添加流对象
//		v.add(new FileInputStream("2.txt"));
//		v.add(new FileInputStream("3.txt"));
//		v.add(new FileInputStream("4.txt"));
		
		ArrayList<FileInputStream> al = new ArrayList<FileInputStream>();//效率高，但是没有枚举，只有自己去new枚举对象
		for(int x=1; x<=5; x++){
			al.add(new FileInputStream(x+".txt"));
		}
		
		Enumeration<FileInputStream> en = Collections.enumeration(al);
		
		SequenceInputStream sis = new SequenceInputStream(en);//new一个序列流对象，往里边传一个枚举类型的参数；将多个源合并为一个源
		
		FileOutputStream fos = new FileOutputStream("6.txt");//自定义一个缓冲区6.txt
		
		byte[] buf = new byte[1024];//缓冲区大小为1024kb
		
		int len = 0;
		
		//循环读取源中的内容，并写入到缓冲区中
		while((len=sis.read(buf))!=-1){
			fos.write(buf,0,len);
		}
		
		//关闭流
		fos.close();
		sis.close();
		
	}

}
