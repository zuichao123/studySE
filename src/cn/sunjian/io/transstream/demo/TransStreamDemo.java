package cn.sunjian.io.transstream.demo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class TransStreamDemo {

	public static void main(String[] args) throws IOException {
		
//		demo_1();//字节转字符
//		demo_2();//字符转字节
		
		demo_3();//简写--常用--死记
		
		
	}

	public static void demo_3() throws IOException {
		
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
		
		BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String line = null;
		
		//字节转字符输出
//		while((line=bufr.readLine())!=null){
//			if ("over".equals(line)) {
//				break;
//			}
//			System.out.println(line.toLowerCase());
//		}
		
		//字符转字节输出
		while((line=bufr.readLine())!=null){
			if ("over".equals(line)) {
				break;
			}
			bufw.write(line.toUpperCase());
			bufw.newLine();
			bufw.flush();
		}
	}

	public static void demo_2() throws IOException {
		//字节流输入
		InputStream in = System.in;
		//字节转字符桥梁
		InputStreamReader isr = new InputStreamReader(in);
		//装饰
		BufferedReader bufr = new BufferedReader(isr);
		
		//字节流 输出
		OutputStream out = System.out;
		//字符转字节的桥梁（操作字符转成字节）
		OutputStreamWriter ousw = new OutputStreamWriter(out);
		//装饰
		BufferedWriter bufw = new BufferedWriter(ousw);
		
		String line = null;

		while((line=bufr.readLine())!=null){
			if ("over".equals(line)) {
				break;
			}
			bufw.write(line.toUpperCase());
			bufw.newLine();
			bufw.flush();
		}
	}

	/**
	 * @throws IOException
	 */
	public static void demo_1() throws IOException {
		//字节流
		InputStream in = System.in;

		//将字节转成字符的桥梁（转换流）
		InputStreamReader isr = new InputStreamReader(in);
		//字符流
		BufferedReader bufr = new BufferedReader(isr);
		
		String line = null;
		
		while((line=bufr.readLine())!=null){
			if("over".equals(line))
				break;
			System.out.println(line.toUpperCase());
		}
	}

}
