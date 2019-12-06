package cn.sunjian.collection_collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Collections�����ࣺ
 * 	
 * 		
 * 
 * @author sunjian
 *
 */
public class CollectionsDemo {

	public static void main(String[] args) {
		
		List<String> list2 = new ArrayList<String>();
		
		//Ϊ�����������
		Collections.addAll(list2, "hello","world","���","����");
		Collections.addAll(list2, "hello2","world2","���2","����2");
		Collections.addAll(list2, "hello3","world3","���3","����3");
		printCollection(list2);
		
		//���ݷ�ת
		Collections.reverse(list2);
		System.out.println("��ת������ݣ�");
		printCollection(list2);
		
		//���ݼ���
		int point = Collections.binarySearch(list2, "hello");
		System.out.println("���������"+point);
		
		//�滻ָ������		
		if (Collections.replaceAll(list2, "hello", "Hello")) {
			System.out.println("�滻������ݣ�");
			printCollection(list2);
		}else {
			System.out.println("�滻ʧ�ܣ�");
		}
		
		//����
		Collections.sort(list2);
		System.out.println("���������ݣ�");
		printCollection(list2);
		
		//ָ��λ�ý���
		Collections.swap(list2, 3, 6);
		System.out.println("����������ݣ�");
		printCollection(list2);
		
		/*
		 * Collections����������
		 */
		@SuppressWarnings("unused")
		List<String> list = Collections.emptyList();//���ز��ɱ�Ŀ�List����
		@SuppressWarnings("unused")
		Set<String> set = Collections.emptySet();//���ز��ɱ�Ŀ�Set����
		
		//list.add("hello");//����ģ������Լ�������
		//set.add("world");//����ģ������Լ�������
		
		
	}

	private static void printCollection(List<String> list2) {
		Iterator<String> iterator = list2.iterator();
		while(iterator.hasNext()){
			System.out.print(iterator.next()+"��");
		}
		System.out.println();
	}

}
