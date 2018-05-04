package cn.sunjian.io.serializable;

import java.io.Serializable;

/**
 * �������л��ͷ����л�������ϰ
 * 
 * @author jack
 *
 */

public class Person implements Serializable {

	private static final long serialVersionUID = 1L;//JDK�汾��֤
	private transient String name;//ʹ��transient�ؼ������������ԣ����Բ������л�
	private int age;
	
	public Person(String name,int age){
		this.age = age;
		this.name = name;
	}
	public String toString(){
		return "������"+name+"���䣺"+age;
	}

}
