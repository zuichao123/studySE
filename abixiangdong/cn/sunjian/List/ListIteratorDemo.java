package cn.sunjian.List;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * ��ϰIterator�ӿڵ��ӽӿڣ�ListIterator
 * @author sunjian
 *
 */

public class ListIteratorDemo {

	public static void main(String[] args) {

		List<String> list = new ArrayList<String>();
		
		list.add("abc1");
		list.add("abc2");
		list.add("abc3");  
		
		System.out.println("list:"+list);
		ListIterator<String> it = list.listIterator(); //��ȡ�б����������
						//������ʵ���ڵ��������ж�Ԫ�ص���ɾ�Ĳ飻
						//ע�⣺ֻ��list���Ͼ߱��ù��ܡ�
		
		while(it.hasNext()){
			
			Object obj = it.next();
			if (obj.equals("abc2")) {
//				it.add("abc9");
				it.set("abc9");
			}else {
				System.out.println(obj);
			}
		}
		System.out.println(list);
		
		
		//�����ȡԪ��
		while(it.hasPrevious()){
			System.out.println("hasPrevious"+it.previous());
		}
		System.out.println(list);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*Iterator it = list.iterator();
		while(it.hasNext()){
			
			Object obj = it.next(); //java.util.ConcurrentModificationException
							//�ڵ��������в�Ҫʹ�ü��ϲ���Ԫ�أ����׳����쳣��
					//����ʹ��Iterator�ӿ��е��ӽӿ�ListIterator������ڵ����ж�Ԫ�ؽ��и���Ĳ�����
			if (obj.equals("abc2")) {
				list.add("abc9");
			}
			else {
				System.out.println("next:"+obj);
			}
		}
		System.out.println(list);*/
	}

}
