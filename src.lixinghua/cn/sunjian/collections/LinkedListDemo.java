package cn.sunjian.collections;

import java.util.LinkedList;

/**
 * LinkedList���ϲ�����ϰ��
 * 
 * 		�������
 * 
 * @author jack
 *
 */
public class LinkedListDemo {

	public static void main(String[] args) {

		LinkedList<String> link = new LinkedList<String>();
		
		link.add("A1");//����Ԫ��
		link.add("A2");
		link.add("A3");
		System.out.println("��ʼ������"+link);
		
		link.addFirst("B1");//������ͷ��������
		link.addLast("B2");//�������β��������
		
		System.out.println("����ͷ��β֮�������"+link);
		
	}

}
