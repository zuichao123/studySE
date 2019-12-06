package cn.sunjian.collection_map;

import java.util.Map;
import java.util.WeakHashMap;

/**
 * Map集合练习：
 * 
 * 		WeakHashMap：弱引用的Map集合，当集合中的某些内容不再使用时，可以清除掉无用的数据，可以使用gc进行回收；
 *  
 * @author jack
 *
 */
public class WeakHashMapDemo {

	public static void main(String[] args) {

		Map<String, String> map = null;//声明Map对象，其中key和value的值为String类型
		
		map = new WeakHashMap<String,String>();//子类实例化父接口对象
		
		map.put(new String("sunjian"), new String("123456"));
		map.put(new String("sunjian1"), new String("123457"));
		map.put(new String("sunjian2"), new String("123458"));
		
		System.gc();//强制性进行垃圾的收集操作
		
		map.put(new String("sunjian"), new String("123456"));

		System.out.println(""+map);
		
	}

}
