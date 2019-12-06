package cn.sunjian.hashmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * ��ʾhashMap�洢�Զ������
 * ʹ��keySet()������mapת��set��ȡ��ֵ
 * 
 * @author sunjian
 *
 */
@SuppressWarnings("unused")
public class HashMapDemo {

	public static void main(String[] args) {
		
		/*
		 * ��ѧ�������ѧ���Ĺ�����ͨ������ֵ�洢��map������
		 */
		
		HashMap<Student, String> hMap= new HashMap<Student, String>();
		
		hMap.put(new Student(23, "tyui"), "ɽ���ٷ�");
		hMap.put(new Student(29, "oiuytrew"), "ɽ����Ȫ");
		hMap.put(new Student(37, "hjk"), "ɽ������");
		hMap.put(new Student(20, "qwesd"), "ɽ���˳�");
		hMap.put(new Student(21, "lkjmnbv"), "����");
		
		System.out.println(hMap);
		
//		Set<Student> set = hMap.keySet();
//		Iterator<Student> it = set.iterator();
		//�ϱ��������ͬ���±���һ��
		Iterator<Student> it = hMap.keySet().iterator();
		
		while(it.hasNext()){
			Student key = it.next();
			String value = hMap.get(key);
			
			System.out.println(key.getAge()+"::"+key.getName()+"---"+value);
		}
		
	}

}
