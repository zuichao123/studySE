package cn.sunjian.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Itreator�ӿڣ��������
 * 		
 * 		���÷�����ϰ��
 * 			�������
 * 			ɾ������
 * 
 * @author jack
 *
 */
public class IteratorDemo {

	public static void main(String[] args) {

		List<String> allList = new ArrayList<String>();
		
		allList.add("hello");
		allList.add("hello1");
		allList.add("_");		
		allList.add("world");
		
		Iterator<String> iterator = allList.iterator();//ͨ��iterator()������Iterator�ӿ�ʵ����
		
		while(iterator.hasNext()){//�ж��Ƿ�������
			String str = iterator.next();
			if ("_".equals(str)) {
				iterator.remove();//ɾ����Ԫ��
			}else {				
				System.out.println(str);//�������
			}
		}
		
		/*
		 * ��ʵ�ʲ����У����ٵ���remove()��������Ϊ����Ҫ�������������
		 */
	}

}
