package cn.sunjian.io.system;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

/**
 * System类对于IO的支持
 * 
 * 		输入、输出重定向：
 * 			
 * 
 * @author jack
 *
 */
public class SystemSetDemo {

	public static void main(String[] args) throws IOException {

		reSystemOut();
		reSystemOut2();
		reSystemErr();
		reSystemIn();
	
	}

	//重定向键盘录入信息
	private static void reSystemIn() {

		try {
			System.setIn(
					new FileInputStream(
							new File("c:"+File.separator+"text8.txt")));//设置输入重定向
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		InputStream input = System.in;//实例化，字节输入流（从文件中接收数据）
		
		byte[] b = new byte[1024];//存放键盘录入的信息
		int len = 0;
		try {
			len = input.read(b);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("输入的内容：\r\n"+new String(b,0,len));
		
		try {
			input.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//将输出的错误新重定向
	private static void reSystemErr() {

		ByteArrayOutputStream bos = null;//定义内存输出流
		
		bos = new ByteArrayOutputStream();//实例化
		
		System.setErr(new PrintStream(bos));//输出重定向
		System.err.println("12345678lsfgdlfgk");//将错误信息输出到内存中
		
		System.out.println(bos);//将内存中保存的信息输出
	}

	//将报错信息重定向
	private static void reSystemOut2() {

		String str = "jack";
		
		try {
			System.out.println(Integer.parseInt(str));
		} catch (Exception e) {
			try {
				System.setOut(
						new PrintStream(
								new FileOutputStream(
										new File("c:"+File.separator+"error.log"))));//输出重定向
			} catch (FileNotFoundException e1) { }
			System.out.println(e);
		}
	}

	//将输出信息重定向
	private static void reSystemOut() {
		try {
			System.setOut(
					new PrintStream(
							new FileOutputStream(
									new File("c:"+File.separator+"text8.txt"))));//输出重定向
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		System.out.print("山西临汾，");
		System.out.println("sunjian");
	}

}
