package cn.sunjian.collection_map;

import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Map集合练习：
 * 
 * 		HashMap：无序存放的，是旧的操作类，key不允许重复；
 * 			增加、取出内容
 * 
 * 		可以使用map.containsKey()方法判断key是否存在
 * 		可以使用map.containsValue()方法判断Value是否存在
 * 
 * @author jack
 *
 */
public class HashTableDemo {

	public static void main(String[] args) {

		Map<String, String> map = null;//声明Map对象，其中key和value的值为String类型
		
		map = new Hashtable<String,String>();//子类实例化父接口对象
		
		map.put("sunjian", "is chinese people!");//增加内容
		map.put("sunjian1", "is chinese peple!");
		map.put("sunjian2", "is chinese peple!");
		map.put("sunjian3", "is chinese peple!");
		map.put("sunjian4", "is chinese peple!");
		
		String val = map.get("sunjian");//根据key取出值
		
		System.out.println("取出的内容："+val);//输出内容
		
		if (map.containsKey("sunjian")) {
			System.out.println("搜索的key存在！");
		}else {
			System.out.println("搜索的key不存在！");
		}
		
		if (map.containsValue("is chinese people!")) {
			System.out.println("搜索的value存在！");
		}else {
			System.out.println("搜索的value不存在！");
		}
		
		/*
		 * 如果要输出全部的key时，使用：Set接口中的map.keys()方法； 
		 */
		System.out.print("全部的key：");
		Set<String> keys = map.keySet();//得到全部的键key
		Iterator<String> iterator = keys.iterator();//调用iterator()方法实例化Iterator接口对象
		while(iterator.hasNext()){//判断内容是否存在
			String str = iterator.next();//输出内容
			System.out.print(str+"、");
		}
		
		System.out.print("\n全部的value：");
		/*
		 * 输出全部的value，使用：Collection接口中的map.values()方法；
		 */
		Collection<String> values = map.values();//得到全部的value值
		Iterator<String> iterator2 = values.iterator();
		while(iterator2.hasNext()){
			String str2 = iterator2.next();
			System.out.print(str2+"、");
		}
		
	}

}
