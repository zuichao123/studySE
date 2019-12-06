package cn.sunjian.io_serializable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 对象序列化和反序列化操作练习
 * 
 * 		序列化+反序列化：一组对象
 * 			对象输入流：ObjectInputStream练习
 * 			对象输出流：ObjectOutputStream练习
 * 
 * @author jack
 *
 */

public class SerializableDemo3 implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		Person[] person = {new Person("张三",30),new Person("李四", 31),new Person("王五", 32)};
		ser(person);
		
		Object[] o = desr();
		
		for(int i=0;i<o.length;i++){
			Person p = person[i];
			System.out.println(p);
		}
	}

	public static void ser(Object[] obj) throws IOException {
		File file = new File("c:"+File.separator+"serialzable3.txt");//定义保存路径
		
		ObjectOutputStream oos = new ObjectOutputStream(
				new FileOutputStream(file));//实例化对象输出流
		
		oos.writeObject(obj);//保存对象 
		
		oos.close();//关闭对象输出流
	}

	public static Object[] desr() throws IOException, ClassNotFoundException {
		File file = new File("c:"+File.separator+"serialzable3.txt");//定义保存路径
		
		ObjectInputStream ois = new ObjectInputStream(
				new FileInputStream(file));//实例化对象输入流
		
		Object[] temp = (Object[])ois.readObject();//读取对象
		
		ois.close();//关闭对象输入流
		
//		System.out.println(temp);
//		System.out.println(""+temp.toString());//打印内容

		return temp;
	}

}
