package cn.sunjian.io_externalizable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 对象序列化和反序列化操作练习
 * 
 * 		手工序列化和手工反序列化：操作
 * 			
 * 		在使用Externalizable接口的时候需要在被序列化的类中定义一个无参构造，
 * 		因为此接口在进行反序列化的时候，会先使用类中无参构造方法为其进行实例化，
 * 		之后再将内容分别设置到属性之中。
 * 
 * @author jack
 *
 */

public class ExerinalizableDemo {

	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		ser();//手工序列化
		dser();//手工反序列化
	}
	
	public static void ser() throws IOException {
		File file = new File("c:"+File.separator+"exerialzable.txt");//定义保存路径
		
		ObjectOutputStream oos = new ObjectOutputStream(
				new FileOutputStream(file));//实例化对象输出流
		
		oos.writeObject(new Person("sunjian2", 31));//保存对象 
		
		oos.close();//关闭对象输出流
	}
	public static void dser() throws IOException, ClassNotFoundException {
		File file = new File("c:"+File.separator+"exerialzable.txt");//定义保存路径
		
		ObjectInputStream ois = new ObjectInputStream(
				new FileInputStream(file));//实例化对象输入流
		
		Object temp = ois.readObject();//读取对象
		
		ois.close();//关闭对象输入流
		
		System.out.println(temp);
//		System.out.println(""+temp.toString());//打印内容

	}

}
