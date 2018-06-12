package cn.sunjian.io_externalizable;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * �������л��ͷ����л�������ϰ
 * 
 * 		�ֹ����л���Externalizable�ӿ���ϰ
 * 			
 * @author jack
 *
 */

public class Person implements Externalizable {

	private static final long serialVersionUID = 1L;//JDK�汾��֤
	private String name;
	private int age;
	
	public Person(){}
	public Person(String name,int age){
		this.age = age;
		this.name = name;
	}
	public String toString(){
		return "������"+name+"���䣺"+age;
	}
	
	@Override
	public void writeExternal(ObjectOutput out)throws IOException {
		out.writeObject(this.name);//������������
		out.writeInt(this.age);//������������
	}
	@Override
	public void readExternal(ObjectInput in)throws IOException, ClassNotFoundException {
		this.name = (String) in.readObject();//��ȡ����
		this.age = in.readInt();//��ȡ����
	}
	
}
