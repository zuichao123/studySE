package cn.sunjian.io_externalizable;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * 对象序列化和反序列化操作练习
 * 
 * 		手工序列化：Externalizable接口练习
 * 			
 * @author jack
 *
 */

public class Person implements Externalizable {

	private static final long serialVersionUID = 1L;//JDK版本验证
	private String name;
	private int age;
	
	public Person(){}
	public Person(String name,int age){
		this.age = age;
		this.name = name;
	}
	public String toString(){
		return "姓名："+name+"年龄："+age;
	}
	
	@Override
	public void writeExternal(ObjectOutput out)throws IOException {
		out.writeObject(this.name);//保存姓名属性
		out.writeInt(this.age);//保存年龄属性
	}
	@Override
	public void readExternal(ObjectInput in)throws IOException, ClassNotFoundException {
		this.name = (String) in.readObject();//读取姓名
		this.age = in.readInt();//读取年龄
	}
	
}
