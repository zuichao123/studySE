package cn.sunjian.io_serializable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * �������л��ͷ����л�������ϰ
 * 
 * 		���л�+�����л���һ�����
 * 			������������ObjectInputStream��ϰ
 * 			�����������ObjectOutputStream��ϰ
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
		
		Person[] person = {new Person("����",30),new Person("����", 31),new Person("����", 32)};
		ser(person);
		
		Object[] o = desr();
		
		for(int i=0;i<o.length;i++){
			Person p = person[i];
			System.out.println(p);
		}
	}

	public static void ser(Object[] obj) throws IOException {
		File file = new File("c:"+File.separator+"serialzable3.txt");//���屣��·��
		
		ObjectOutputStream oos = new ObjectOutputStream(
				new FileOutputStream(file));//ʵ�������������
		
		oos.writeObject(obj);//������� 
		
		oos.close();//�رն��������
	}

	public static Object[] desr() throws IOException, ClassNotFoundException {
		File file = new File("c:"+File.separator+"serialzable3.txt");//���屣��·��
		
		ObjectInputStream ois = new ObjectInputStream(
				new FileInputStream(file));//ʵ��������������
		
		Object[] temp = (Object[])ois.readObject();//��ȡ����
		
		ois.close();//�رն���������
		
//		System.out.println(temp);
//		System.out.println(""+temp.toString());//��ӡ����

		return temp;
	}

}
