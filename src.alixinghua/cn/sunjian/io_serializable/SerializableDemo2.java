package cn.sunjian.io_serializable;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/**
 * �������л��ͷ����л�������ϰ
 * 
 * 		�����л���һ������
 * 			������������ObjectIntputStream��ϰ
 * 
 * @author jack
 *
 */

public class SerializableDemo2 implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		File file = new File("c:"+File.separator+"serialzable.txt");//���屣��·��
		
		ObjectInputStream ois = new ObjectInputStream(
				new FileInputStream(file));//ʵ��������������
		
		Object temp = ois.readObject();//��ȡ����
		
		ois.close();//�رն���������
		
		System.out.println(temp);
//		System.out.println(""+temp.toString());//��ӡ����

	}

}
