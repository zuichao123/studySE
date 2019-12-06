package cn.sunjian.collection_map;

import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Map������ϰ��
 * 
 * 		IdentityHashMap��
 * 			����HashMap��key�����ظ��������������ϣ��key�����ݿ����ظ�������ĵ�ַ��һ��������Ҫʹ��IdentityHashMap�ࡣ
 * 
 * @author jack
 *
 */
class Person2{
	private String name;
	private int age;
	
	public Person2(String name,int age){
		this.age = age;
		this.name = name;
	}
	public String toString(){
		return "������"+this.name+",���䣺"+this.age;
	}
	
	public boolean equals(Object obj){
		if (this == obj) {
			return true;
		}
		
		if (!(obj instanceof Person2)) {
			return false;
		}
		
		Person2 p = (Person2) obj;
		if (this.name.equals(p.name) && this.age == p.age) {
			return true;
		}else {
			return false;
		}
	}
	
	public int hashCode(){
		return this.name.hashCode() * this.age;
	}
}

public class IdentityHashMapDemo {

	public static void main(String[] args) {

		Map<Person2, String> map = null;//����Map��������key��ֵ��һ�������value��ֵΪString����
		
		map = new IdentityHashMap<Person2, String>();//����ʵ�������ӿڶ���
		
		map.put(new Person2("sunjian", 30), "�｡");//key��һ����������
		map.put(new Person2("sunjian", 30), "�｡2");//key��һ����������
		map.put(new Person2("sunjian", 30), "�｡3");//key��һ����������
		
		Set<Map.Entry<Person2, String>> allSet = null;
		allSet = map.entrySet();
		
		Iterator<Map.Entry<Person2, String>> iter = allSet.iterator();
		
		while(iter.hasNext()){
			Map.Entry<Person2, String> sss = iter.next();
			
			System.err.println(sss.getKey()+"-->"+sss.getValue());
		}
	}
}
