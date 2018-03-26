package cn.sunjian.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * map 集合=-练习
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
	
	//取出map中的所有的值
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
	 * 通过map转成set就可以迭代
	 * 找到了另一个方法，entrySet()
	 * 该方法将键和值的映射关系作为对象存储到了set集合中，而这个映射关系的类型就是Map.Entry类型（结婚证）
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
		
		
		
		//取出map中的所有元素
		Set<Integer> set = map.keySet();
		Iterator<Integer> it = set.iterator();
		while(it.hasNext()){
			
			Integer key = it.next();
			String value = map.get(key);
			System.out.println(key+":"+value);
		}
		
		
		
	
	}

	public static void method(Map<Integer, String> map){
		
		//添加元素
		map.put(8, "wangcaikkk");
		System.out.println(map.put(8, "wangcai"));
		System.out.println(map.put(8, "xiaoqiang"));
		map.put(2, "zhangliu");
		System.out.println(map);
		//删除元素
//		System.out.println("remove:"+map.remove(2));
	
		//判断元素
//		System.out.println("containskey:"+map.containsKey(8));
	
		//获取元素
//		System.out.println("get:"+map.get(6));
	
	}
}
