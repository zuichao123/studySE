package cn.sunjian.collection_map;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Map接口练习：
 * 
 * 		SortedMap类：是TreeMap的父类
 * 			Map集合排序操作
 * 			
 * 
 * @author sunjian
 *
 */
public class SortedMapDemo {

	public static void main(String[] args) {

		SortedMap<String, String> map = new TreeMap<String,String>();
		
		map.put("C、", "程程程程程错错错错错错错错");
		map.put("B、", "编编编编编编编编不不不不不不不");
		map.put("A、", "啊啊啊啊啊啊啊啊啊啊不不不不不不不");
		map.put("L、", "编啦啦啦啦啦绿绿绿绿绿不不不不不不不");
		map.put("Y、", "要要要要要要要要晕不不不不不");
		map.put("D、", "顶顶顶顶顶顶顶顶顶顶大大大");
		
		System.out.print("第一个元素的内容的key："+map.firstKey());
		System.out.println("对应的value值："+map.get(map.firstKey()));
		
		System.out.print("最后个元素的内容的key："+map.lastKey());
		System.out.println("对应的value值："+map.get(map.lastKey()));
	
		System.out.println("返回小于指定范围的集合：");
		for(Map.Entry<String, String> me : map.headMap("D、").entrySet()){
			System.out.println(me.getKey()+"-->"+me.getValue());
		}
	
		System.out.println("返回大于指定范围的集合：");
		for(Map.Entry<String, String> me : map.tailMap("D、").entrySet()){
			System.out.println(me.getKey()+"-->"+me.getValue());
		}
		
		System.out.println("返回部分范围的集合：");
		for(Map.Entry<String, String> me : map.subMap("B、", "L、").entrySet()){
			System.out.println(me.getKey()+"-->"+me.getValue());
		}
		
	}

}
