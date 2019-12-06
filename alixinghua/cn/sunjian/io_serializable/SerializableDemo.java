package cn.sunjian.io_serializable;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 对象序列化和反序列化操作练习
 * 
 * 		序列化：一个对象
 * 			对象输出流：ObjectOutputStream练习
 * 
 * @author jack
 *
 */

public class SerializableDemo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) throws IOException {
		File file = new File("c:"+File.separator+"serialzable.txt");//定义保存路径
		
		ObjectOutputStream oos = new ObjectOutputStream(
				new FileOutputStream(file));//实例化对象输出流
		
		oos.writeObject(new Person("sunjian", 30));//保存对象 
		
		oos.close();//关闭对象输出流
	}

}
