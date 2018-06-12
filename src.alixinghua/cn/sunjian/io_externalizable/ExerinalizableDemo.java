package cn.sunjian.io_externalizable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * �������л��ͷ����л�������ϰ
 * 
 * 		�ֹ����л����ֹ������л�������
 * 			
 * 		��ʹ��Externalizable�ӿڵ�ʱ����Ҫ�ڱ����л������ж���һ���޲ι��죬
 * 		��Ϊ�˽ӿ��ڽ��з����л���ʱ�򣬻���ʹ�������޲ι��췽��Ϊ�����ʵ������
 * 		֮���ٽ����ݷֱ����õ�����֮�С�
 * 
 * @author jack
 *
 */

public class ExerinalizableDemo {

	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		ser();//�ֹ����л�
		dser();//�ֹ������л�
	}
	
	public static void ser() throws IOException {
		File file = new File("c:"+File.separator+"exerialzable.txt");//���屣��·��
		
		ObjectOutputStream oos = new ObjectOutputStream(
				new FileOutputStream(file));//ʵ�������������
		
		oos.writeObject(new Person("sunjian2", 31));//������� 
		
		oos.close();//�رն��������
	}
	public static void dser() throws IOException, ClassNotFoundException {
		File file = new File("c:"+File.separator+"exerialzable.txt");//���屣��·��
		
		ObjectInputStream ois = new ObjectInputStream(
				new FileInputStream(file));//ʵ��������������
		
		Object temp = ois.readObject();//��ȡ����
		
		ois.close();//�رն���������
		
		System.out.println(temp);
//		System.out.println(""+temp.toString());//��ӡ����

	}

}
