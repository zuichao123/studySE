package cn.sunjian.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * ��ϰiterator
 * @author sunjian
 *
 */
public class IteratorDemos {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		
		Collection coll = new ArrayList();
		
		coll.add("abc1");
		coll.add("abc2");
		coll.add("abc3");
		coll.add("abc4");

		//ʹ����Collection�е�iterator()����;���ü����еĵ�������������Ϊ�˻�ȡ�����еĵ���������
		 
		//����whileѭ��ȡֵ��ȡ��ֵ��it�����������ڴ���
		Iterator it = coll.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
		System.out.println("***************************************");
		
		//������ʹ������
		for(Iterator it1 = coll.iterator(); it1.hasNext(); ){
			System.out.println(it1.next());
		}
		
	}

}
