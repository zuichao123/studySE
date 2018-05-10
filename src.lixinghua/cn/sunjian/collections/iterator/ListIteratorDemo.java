package cn.sunjian.collections.iterator;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * ListItreator�ӿڣ�˫�����
 * 		
 * 		���÷�����ϰ��
 * 			�������
 * 			�޸�����
 * 			��������
 * 
 * @author jack
 *
 */
public class ListIteratorDemo {

	public static void main(String[] args) {

		List<String> allList = new ArrayList<String>();
		
		allList.add("hello");
		allList.add("hello1");
		allList.add("_");		
		allList.add("world");
		
		ListIterator<String> iterator = allList.listIterator();//ͨ��iterator()������Iterator�ӿ�ʵ����
		
		System.out.print("��ǰ��������");
		while(iterator.hasNext()){//�ж��Ƿ�������
			String str = iterator.next();
			System.out.print(str+"��");//�������
			iterator.set("sun"+str);//�޸�����
		}
		
		
		System.out.print("\n�ɺ���ǰ�����");
		while(iterator.hasPrevious()){
			iterator.add("sun");
			String str = iterator.previous();
			System.out.print(str+"��");
		}
		
		/*
		 * ע�⣺�˲���ʱ�������Ƚ�����ǰ����ٽ����Һ���ǰ�Ĳ�����
		 * 	   ���Ҫ��ʹ��ListIterator�ӿڣ���ֻ������List�ӿ���ɣ�
		 */
	}

}
