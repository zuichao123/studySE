package cn.sunjian.io_inputstream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * InputStream类操作练习：字节输入流（就是读取操作）
 * 
 * 		读取内容：
 * 		
 * 			读到文件末尾：代表-1
 * 
 * @author jack
 *
 */
public class InputStreamDemo3 {

	public static void main(String[] args) throws IOException {

		//1.使用File类找到一个文件
		File file = new File("c:"+File.separator+"text2.txt");
		
		//2.通过子类实例化父类对象
		InputStream in = null;//准备好一个输入的对象
		in = new FileInputStream(file);//通过对象的多态性，进行实例化
		
		//3.读取内容
		byte b[] = new byte[(int) file.length()];//所有的数据都读取到byte数组中【数组的大小由文件大小决定】
		
		int len = 0;//记录数组长度
		int temp = 0;//接收每一个读取进来的数据
		
		/*
		 * 当不知道读取内容有多大的时候，使用此方法
		 */
		while((temp = in.read()) != -1){
			//表示还有内容，没有读完
			b[len] = (byte) temp;
			len++;
		}
		
		//从头开始读，读到结尾
		System.out.println("内容："+new String(b));//把byte数组转换成字符串，进行输出
		
		//4.关闭输入流
		in.close();		
		
	}

}
