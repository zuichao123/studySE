package cn.sunjian.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * map ����=-��ϰ
 * 
 * @author sunjian
 *
 */
public class MapDemo {

	public static void main(String[] args) {
		
		Map<Integer, String> map = new HashMap<Integer,String>();
		method(map);
		method_2(map);
		method_3(map);
		values(map);
	}
	
	//ȡ��map�е����е�ֵ
	private static void values(Map<Integer, String> map) {
		map.put(7, "hadfjdlfj");
		map.put(57, "hadfjdlfj5678");
		map.put(87, "1234hadfjdlfjk");
		
		Collection<String> collection = map.values();
		Iterator<String > iterator = collection.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
	}

	/*
	 * ͨ��mapת��set�Ϳ��Ե���
	 * �ҵ�����һ��������entrySet()
	 * �÷���������ֵ��ӳ���ϵ��Ϊ����洢����set�����У������ӳ���ϵ�����;���Map.Entry���ͣ����֤��
	 * 
	 */
	private static void method_3(Map<Integer, String> map) {
		map.put(345, "tyui");
		map.put(65, "8765467");
		map.put(34, "iuytrw");
		
		Set<Map.Entry<Integer, String>> set = map.entrySet();
		Iterator<Map.Entry<Integer, String>> it = set.iterator();
		while(it.hasNext()){
			Map.Entry<Integer, String> me = it.next();
			Integer key = me.getKey();
			String value = me.getValue();
			System.out.println(key+"---"+value);
		}
	}

	private static void method_2(Map<Integer, String> map) {
		
		map.put(2, "sdfjldsdslk");
		map.put(6, "sdfjthgfldkgyu");
		map.put(9, "sdfjldfghd");
		map.put(4, "ghfg");
		
		
		
		//ȡ��map�е�����Ԫ��
		Set<Integer> set = map.keySet();
		Iterator<Integer> it = set.iterator();
		while(it.hasNext()){
			
			Integer key = it.next();
			String value = map.get(key);
			System.out.println(key+":"+value);
		}
		
		
		
	
	}

	public static void method(Map<Integer, String> map){
		
		//���Ԫ��
		map.put(8, "wangcaikkk");
		System.out.println(map.put(8, "wangcai"));
		System.out.println(map.put(8, "xiaoqiang"));
		map.put(2, "zhangliu");
		System.out.println(map);
		//ɾ��Ԫ��
//		System.out.println("remove:"+map.remove(2));
	
		//�ж�Ԫ��
//		System.out.println("containskey:"+map.containsKey(8));
	
		//��ȡԪ��
//		System.out.println("get:"+map.get(6));
	
	}
}
