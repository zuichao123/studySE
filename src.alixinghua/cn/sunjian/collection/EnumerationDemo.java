package cn.sunjian.collection;

import java.util.Enumeration;
import java.util.Vector;

/**
 * Enumeration������ϰ��
 * 
 * 		ѭ�����
 * 
 * @author jack
 *
 */
public class EnumerationDemo {

	public static void main(String[] args) {

		Vector<String> allList = new Vector<String>();
		
		allList.add("hello");
		allList.add("_");
		allList.add("world");
		
		Enumeration<String> enu = allList.elements();
		
		while(enu.hasMoreElements()){//�ж��Ƿ�������
			System.out.println(enu.nextElement());//�������
		}
	}

}
