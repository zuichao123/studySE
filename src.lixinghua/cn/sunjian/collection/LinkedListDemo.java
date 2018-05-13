package cn.sunjian.collection;

import java.util.LinkedList;

/**
 * LinkedList���ϲ�����ϰ��
 * 
 * 		���������
 * 			����Ԫ�ء���ͷ����β
 * 			�ұ�ͷ(ɾ������ɾ��)
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
		
		System.out.println("\nʹ��element()�������ҵ���ͷ��"+link.element());
		System.out.println("����֮����������ݣ�"+link);
		
		System.out.println("\nʹ��peek()�����ҵ���ͷ��"+link.peek());
		System.out.println("����֮����������ݣ�"+link);
		
		System.out.println("\nʹ��poll()�����ҵ���ͷ��"+link.poll());
		System.out.println("����֮����������ݣ�"+link);
		
		System.out.println(link.size());
		
		System.out.println("\n��FIFO�ķ�ʽ�����");
		for(int i=0;i<=link.size()+1;i++){//�Ƚ��ȳ��ķ�ʽ���
			System.out.print(link.poll()+"��");
		}
		
	}

}
