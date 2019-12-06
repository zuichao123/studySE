package cn.sunjian.io_objectStream;

import java.io.FileInputStream;

/**
 * �������л�
 * 
 * ObjectInputStream����ǰʹ��ObjectInputStreamд��Ļ������ݺͶ�����з����л�����д�Ͷ���
 * ֻ�ܶ�ObjectInputStream��д�ġ�
 * 
 * �Ѷ���Ӷ��ڴ�洢��Ӳ����
 * 
 */

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import cn.sunjian.io_objectStream_bean.Person;

public class ObjectStreamDemo {

	public static void main(String[] args) throws IOException, ClassNotFoundException {

//		writeObj();//д������ļ���
		readobj();//��ȡ�ļ��е�����
	}

	public static void readobj() throws IOException, IOException, ClassNotFoundException {
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("obj.object"));
		
		//����ķ����л���һ����ض������ݶ���ʹ�ã����磺���ݿ����Ӷ��󣬴洢���ض����ݵĶ���
		Person p = (Person)ois.readObject();//��Ϊ��ȡʱҪ.class�ļ�����Ҫ���쳣����û���ҵ���
		
		System.out.println(p.getName()+":"+p.getAge());
		
		ois.close();
		
	}

	public static void writeObj() throws IOException, IOException {

		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("obj.object"));//�洢����������ļ�����׺��Ϊ.object
		
		//���л��Ķ������ʵ��Serializable�ӿ�
		oos.writeObject(new Person("Сǿ",30));
		
		oos.close();

	}

}
