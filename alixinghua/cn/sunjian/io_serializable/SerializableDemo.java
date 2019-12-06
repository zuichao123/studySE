package cn.sunjian.io_serializable;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * �������л��ͷ����л�������ϰ
 * 
 * 		���л���һ������
 * 			�����������ObjectOutputStream��ϰ
 * 
 * @author jack
 *
 */

public class SerializableDemo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) throws IOException {
		File file = new File("c:"+File.separator+"serialzable.txt");//���屣��·��
		
		ObjectOutputStream oos = new ObjectOutputStream(
				new FileOutputStream(file));//ʵ�������������
		
		oos.writeObject(new Person("sunjian", 30));//������� 
		
		oos.close();//�رն��������
	}

}
