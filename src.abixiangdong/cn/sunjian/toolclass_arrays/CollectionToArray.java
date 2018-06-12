package cn.sunjian.toolclass_arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 集合转成数组
 * 使用的就是Collection接口中的toArray方法。
 * 集合转成数组：可以对集合中的元素操作的方法进行限定，不允许对其进行增删。
 * 
 * @author sunjian
 *
 */
public class CollectionToArray {

	public static void main(String[] args) {
		
		List<String> list = new ArrayList<String>();
		list.add("abc1");
		list.add("abc2");
		list.add("abc8");
		list.add("abc4");
		
		String[] arr = list.toArray(new String[list.size()]);
		
		System.out.println(Arrays.toString(arr));
	}

}
