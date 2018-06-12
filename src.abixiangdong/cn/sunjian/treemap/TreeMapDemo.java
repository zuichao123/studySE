package cn.sunjian.treemap;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import cn.sunjian.hashmap.Student;


/**
 * ��ʾTreeMap�洢�Զ������
 * ʹ��Map.Entry()������mapת��set��ȡ��ֵ
 * 
 * @author sunjian
 *
 */
public class TreeMapDemo {

	public static void main(String[] args) {
		
		/*
		 * ��ѧ�������ѧ���Ĺ�����ͨ������ֵ�洢��map������
		 */
		
//		TreeMap<Student, String> tMap= new TreeMap<Student, String>();
		TreeMap<Student, String> tMap= new TreeMap<Student, String>(new ComByName());
		
		tMap.put(new Student(23, "tyui"), "ɽ���ٷ�");
		tMap.put(new Student(29, "oiuytrew"), "ɽ����Ȫ");
		tMap.put(new Student(37, "hjk"), "ɽ������");
		tMap.put(new Student(20, "qwesd"), "ɽ���˳�");
		tMap.put(new Student(21, "lkjmnbv"), "����");
		
		System.out.println(tMap);
		
		Iterator<Map.Entry<Student, String>> it = tMap.entrySet().iterator();
		
		while(it.hasNext()){
			Map.Entry<Student, String> me = it.next();

			Student key = me.getKey();
			String value = me.getValue();
			
			System.out.println(key.getAge()+"::"+key.getName()+"---"+value);
		}
		
	}

}
