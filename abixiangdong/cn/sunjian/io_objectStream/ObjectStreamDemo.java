package cn.sunjian.io_objectStream;

import java.io.FileInputStream;

/**
 * 对象序列化
 * 
 * ObjectInputStream对以前使用ObjectInputStream写入的基本数据和对象进行反序列化。（写和读）
 * 只能读ObjectInputStream它写的。
 * 
 * 把对象从堆内存存储到硬盘上
 * 
 */

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import cn.sunjian.io_objectStream_bean.Person;

public class ObjectStreamDemo {

	public static void main(String[] args) throws IOException, ClassNotFoundException {

//		writeObj();//写入对象到文件中
		readobj();//读取文件中的内容
	}

	public static void readobj() throws IOException, IOException, ClassNotFoundException {
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("obj.object"));
		
		//对象的反序列化，一般对特定的数据对象使用（比如：数据库连接对象，存储着特定数据的对象）
		Person p = (Person)ois.readObject();//因为读取时要.class文件所有要抛异常（类没有找到）
		
		System.out.println(p.getName()+":"+p.getAge());
		
		ois.close();
		
	}

	public static void writeObj() throws IOException, IOException {

		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("obj.object"));//存储对象的配置文件，后缀名为.object
		
		//序列化的对象必须实现Serializable接口
		oos.writeObject(new Person("小强",30));
		
		oos.close();

	}

}
