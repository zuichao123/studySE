package cn.sunjian.io_inputstream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * InputStream类操作练习：字节输入流（就是读取操作）
 * 
 * 		读取内容：直接使用byte数组的方式完成
 * 		
 * 			此方法：
 * 			只适合于知道输入流大小的时候。
 * 			此时内容读取进来了，但是有很多的空格，使用read方法返回内容的长度，在根据String类的指定位置进行读取
 *			 根据文件的大小，开辟byte数组空间
 * 
 * @author jack
 *
 */
public class InputStreamDemo {

	public static void main(String[] args) throws IOException {

		//1.使用File类找到一个文件
		File file = new File("c:"+File.separator+"text2.txt");
		
		//2.通过子类实例化父类对象
		InputStream in = null;//准备好一个输入的对象
		in = new FileInputStream(file);//通过对象的多态性，进行实例化
		
		//3.读取内容
		byte b[] = new byte[(int) file.length()];//所有的数据都读取到byte数组中【数组的大小由文件大小决定】
		int len = in.read(b);//读取内容，并返回内容的长度
		
		//从头开始读，读到结尾
		System.out.println("数组长度："+len+"\t\n内容："+new String(b,0,len));//把byte数组转换成字符串，进行输出
		
		//4.关闭输入流
		in.close();		
		
	}

}
