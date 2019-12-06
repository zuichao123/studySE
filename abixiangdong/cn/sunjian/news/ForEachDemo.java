package cn.sunjian.news;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * for each练习
 * 
 * @author sunjian
 *
 */
public class ForEachDemo {

	public static void main(String[] args) {

		List<String> list = new ArrayList<String>();
		list.add("abc");
		list.add("abc");
		list.add("abc");
		
		for(String s:list){
			System.out.println(s);
		}
		
		/**
		 * 传统for和高级for的区别？
		 * 传统for可以完成对语句执行很多次，因为可以定义控制循环的增量和条件。
		 * 
		 * 高级for是一种简化形式。
		 * 它必须有遍历的目标。该目标要么是数组，要么是Collection单列集合。
		 * 
		 * 对数组的遍历如果仅仅是获取数组中的元素，可以使用高级for。
		 * 如果要对数组的角标进行操作建议使用传统for。
		 */
		int[] arr = {4,5,2,7};
		
		for(int i:arr){
			System.out.println(i);
		}
		/**
		 * 高级for可以遍历map集合吗？
		 * 不能直接用，但是可以将map转成单列的set，就可以用了。
		 * 
		 */
		Map<Integer, String> map = new HashMap<Integer, String>();
		
		map.put(3, "sunmiert");
		map.put(13, "sunmghisdg");
		map.put(34, "sdgunmgifgh");
		map.put(73, "htsunmi");
		
		for(Integer key:map.keySet()){
			String value = map.get(key);
			System.out.println(key+"=="+value);
		}
		
		for(Map.Entry<Integer, String> me: map.entrySet()){
			Integer key = me.getKey();
			String value = me.getValue();
			System.out.println(key+"---"+value);
		}
		
		
		
		
		
		
		
		
	}

}
