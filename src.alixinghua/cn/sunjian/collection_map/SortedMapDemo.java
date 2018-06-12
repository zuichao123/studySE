package cn.sunjian.collection_map;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Map�ӿ���ϰ��
 * 
 * 		SortedMap�ࣺ��TreeMap�ĸ���
 * 			Map�����������
 * 			
 * 
 * @author sunjian
 *
 */
public class SortedMapDemo {

	public static void main(String[] args) {

		SortedMap<String, String> map = new TreeMap<String,String>();
		
		map.put("C��", "�̴̳̳̳̳��������");
		map.put("B��", "��������಻������������");
		map.put("A��", "����������������������������������");
		map.put("L��", "���������������������̲�������������");
		map.put("Y��", "ҪҪҪҪҪҪҪҪ�β���������");
		map.put("D��", "������������������������");
		
		System.out.print("��һ��Ԫ�ص����ݵ�key��"+map.firstKey());
		System.out.println("��Ӧ��valueֵ��"+map.get(map.firstKey()));
		
		System.out.print("����Ԫ�ص����ݵ�key��"+map.lastKey());
		System.out.println("��Ӧ��valueֵ��"+map.get(map.lastKey()));
	
		System.out.println("����С��ָ����Χ�ļ��ϣ�");
		for(Map.Entry<String, String> me : map.headMap("D��").entrySet()){
			System.out.println(me.getKey()+"-->"+me.getValue());
		}
	
		System.out.println("���ش���ָ����Χ�ļ��ϣ�");
		for(Map.Entry<String, String> me : map.tailMap("D��").entrySet()){
			System.out.println(me.getKey()+"-->"+me.getValue());
		}
		
		System.out.println("���ز��ַ�Χ�ļ��ϣ�");
		for(Map.Entry<String, String> me : map.subMap("B��", "L��").entrySet()){
			System.out.println(me.getKey()+"-->"+me.getValue());
		}
		
	}

}
