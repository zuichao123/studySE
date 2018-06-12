package cn.sunjian.io_serializable;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/**
 * 对象序列化和反序列化操作练习
 * 
 * 		反序列化：一个对象
 * 			对象输入流：ObjectIntputStream练习
 * 
 * @author jack
 *
 */

public class SerializableDemo2 implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		File file = new File("c:"+File.separator+"serialzable.txt");//定义保存路径
		
		ObjectInputStream ois = new ObjectInputStream(
				new FileInputStream(file));//实例化对象输入流
		
		Object temp = ois.readObject();//读取对象
		
		ois.close();//关闭对象输入流
		
		System.out.println(temp);
//		System.out.println(""+temp.toString());//打印内容

	}

}
