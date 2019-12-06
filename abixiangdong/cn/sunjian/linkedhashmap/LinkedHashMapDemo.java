package cn.sunjian.linkedhashmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 演示--LinkedHashMap
 * 有序(怎么存怎么取)取出map集合中的值
 * 
 * @author sunjian
 *
 */
public class LinkedHashMapDemo {

	public static void main(String[] args) {

//		HashMap<Integer, String> hs = new HashMap<Integer, String>();
		HashMap<Integer, String> hs = new LinkedHashMap<Integer, String>();
		
		hs.put(6, "rtyu76");
		hs.put(16, "krtrtyu");
		hs.put(46, "rtyu45");
		hs.put(261, "765rtyutfr");
		
//		System.out.println(hs);
		
		Iterator<Map.Entry<Integer, String>> it = hs.entrySet().iterator();
		
		while(it.hasNext()){
			Map.Entry<Integer, String> me = it.next();
			
			Integer key = me.getKey();
			String value = me.getValue();
			
			System.out.println(key+":::"+value);
		}
		
	}

}
