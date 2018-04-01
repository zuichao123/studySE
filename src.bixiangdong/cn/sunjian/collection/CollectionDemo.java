package cn.sunjian.collection;

import java.util.ArrayList;
import java.util.Collection;

/**
 * ���Ͽ��
 * 
 * @author sunjian
 *
 */
public class CollectionDemo {

	public static void main(String[] args) {
		
		Collection coll = new ArrayList();
		
//		show(coll);
		
		Collection c1 = new ArrayList();
		Collection c2 = new ArrayList();
		
		show(c1,c2);
		
	}
	
	public static void show(Collection c1, Collection c2){
		
		//��c1���Ԫ��
		c1.add("abc1");
		c1.add("abc2");
		c1.add("abc3");
		c1.add("abc4");
		
		//��c2���Ԫ��
		c2.add("abc2");
		c2.add("abc1");
		c2.add("abc4");
		
		System.out.println("c1��"+c1);
		System.out.println("c2��"+c2);
		
		//��ʾaddAll����
		c1.addAll(c2);
		
		System.out.println("addAll--��c2��ӵ�c1��:"+c1);	
		
		//��ʾremoveAll����
//		boolean b = c1.removeAll(c2);
//		System.out.println("removeAll--ɾ��c1�����е�c2���Ϻ�"+c1);
//		System.out.println("�Ƿ�ɾ���ɹ���"+b);
		
		//��ʾcontainsAll
		boolean b1 = c1.containsAll(c2);
		System.out.println("containAll--c1�����а���c2�����еģ�"+c2);
		System.out.println("containsAll--c1�������Ƿ����c2�����е��������ݣ�"+b1);
		
		//��ʾretainAll
		boolean b2 = c1.retainAll(c2);
		System.out.println("retainAll--ȡc1������c2���ϵĽ�����"+c1);
		System.out.println("c1������c2�����Ƿ��н���"+b2);
		
	}
	
	public static void show(Collection coll){
		
		//1.���Ԫ�ء�add
		coll.add("abc1");
		coll.add("abc2");
		coll.add("abc3");
		
		System.out.println(coll);
		
		//2.ɾ��Ԫ�ء�remove
		coll.remove("abc2");//��ı伯�ϵĳ���
		
		//��ռ���
//		coll.clear();
		
		System.out.println(coll.isEmpty());
		System.out.println(coll.contains("abc3"));
		
		System.out.println(coll);
		
	}

}
