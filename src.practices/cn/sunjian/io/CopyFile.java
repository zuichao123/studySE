package cn.sunjian.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * java.io操作练习：
 * 
 * 		copy源文件    到    目标文件
 * 
 * 	思路：
 * 		如果采用以上的格式，则肯定要使用初始化参数的形式，输入两个路径，所以，此时就必须对输入参数的个数进行验证，判断其是否为2；
 * 		使用字节流：因为，如果拷贝的是一个图片呢
 * 		有两种方式可以采用：
 * 			1.将源文件中的内容全部读取进来，之后一次性写入到目标文件中；
 * 			2。边读边写的方式。	
 * 
 * @author jack
 *
 */
public class CopyFile {

	public static void main(String[] args) {

		if (args.length != 2) {
			System.out.println("输入的参数不正确！");
			System.out.println("例如：java CopyFile 源文件    目标文件");
			System.exit(1);//系统退出
		}
		
		File f1 = new File(args[0]);//实例化源文件对象
		File f2 = new File(args[1]);//实例化目标文件对象
		
		if (!f1.exists()) {//如果目标文件不存在
			System.out.println("源文件不存在");
			System.exit(1);//系统退出
		}
		
		InputStream input = null;//定义字节输入流（读取）对象
		OutputStream out = null;//定义字节输出流（写入）对象
		
		try {			
			input = new FileInputStream(f1);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {			
			out = new FileOutputStream(f2);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		if (input != null && out != null) {//判断输入或者输出是否准备好了
			int temp = 0;//存放读取内容，判断文件是否还有内容
			try {				
				while((temp = input.read()) != -1){
					out.write(temp);
				}
				System.out.println("拷贝完成！");
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("拷贝失败！");
			}
		}
		
		try {
			input.close();//关闭输入流
			out.close();//关闭输出流
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}















