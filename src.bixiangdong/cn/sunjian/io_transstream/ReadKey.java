package cn.sunjian.io_transstream;

import java.io.IOException;
import java.io.InputStream;

/**
 * 读取键盘录入联系
 * 
 * @author sunjian
 *
 */
public class ReadKey {

	public static void main(String[] args) throws IOException {

		readKey_2();
	}

	public static void readKey_2() throws IOException {
		/**
		 * 获取用户键盘录入的数据
		 * 并将数据变成大写显示在控制台上
		 * 如果用户输入的是over，结束键盘录入。
		 * 
		 * 思路：
		 * 1，因为键盘录入只读取一个字节，要判断是否是over，需要将读取到的字节拼成字符串
		 * 2，那就需要一个容器。StringBuilder
		 * 3，在用户回车之间将录入的数据变成字符串判断即可。
		 * 
		 */
		//1,创建容器
		StringBuilder sb = new StringBuilder();
		
		//2,获取键盘读取流
		InputStream in = System.in;
		
		//3,定义变量记录读取到的字节，并循环获取
		int ch = 0;
		 while((ch=in.read())!=-1){
			 
			 //在存储之前需要判断是否是换行标记，因为换行标记不存储
			 if(ch=='\r')
				 continue;
			if(ch=='\n'){
				 String temp = sb.toString();
			 	if("over".equals(temp))
			 		break;
			 	System.out.println(temp.toString());
			 	sb.delete(0, sb.length());
			}
			else {
				//将读取到的字节存储到StringBuilder中
				sb.append((char)ch);
			}
		 }
	}

}
