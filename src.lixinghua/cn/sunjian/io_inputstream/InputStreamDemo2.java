package cn.sunjian.io_inputstream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * InputStream类操作练习：输入流（就是读取操作）
 * 
 * 		读取内容：直接使用read()的方法完成
 * 		
 * 			此方法：
 * 			只适合于知道输入流大小的时候。
 *			 根据文件的大小，开辟byte数组空间
 * 
 * @author jack
 *
 */
public class InputStreamDemo2 {

	public static void main(String[] args) throws IOException {

		//1.使用File类找到一个文件
		File file = new File("c:"+File.separator+"text2.txt");
		
		//2.通过子类实例化父类对象
		InputStream in = null;//准备好一个输入的对象
		in = new FileInputStream(file);//通过对象的多态性，进行实例化
		
		//3.读取内容
		byte b[] = new byte[(int) file.length()];//所有的数据都读取到byte数组中【数组的大小由文件大小决定】
		for(int i=0;i<b.length;i++){
			
			b[i] = (byte)in.read();//读取内容，一个一个的读
		}
		
		//从头开始读，读到结尾
		System.out.println("内容："+new String(b));//把byte数组转换成字符串，进行输出
		
		//4.关闭输入流
		in.close();		
		
	}

}
