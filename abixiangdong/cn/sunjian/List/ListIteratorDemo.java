package cn.sunjian.List;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * 练习Iterator接口的子接口：ListIterator
 * @author sunjian
 *
 */

public class ListIteratorDemo {

	public static void main(String[] args) {

		List<String> list = new ArrayList<String>();
		
		list.add("abc1");
		list.add("abc2");
		list.add("abc3");  
		
		System.out.println("list:"+list);
		ListIterator<String> it = list.listIterator(); //获取列表迭代器对象；
						//它可以实现在迭代过程中对元素的增删改查；
						//注意：只有list集合具备该功能。
		
		while(it.hasNext()){
			
			Object obj = it.next();
			if (obj.equals("abc2")) {
//				it.add("abc9");
				it.set("abc9");
			}else {
				System.out.println(obj);
			}
		}
		System.out.println(list);
		
		
		//逆向获取元素
		while(it.hasPrevious()){
			System.out.println("hasPrevious"+it.previous());
		}
		System.out.println(list);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*Iterator it = list.iterator();
		while(it.hasNext()){
			
			Object obj = it.next(); //java.util.ConcurrentModificationException
							//在迭代过程中不要使用集合操作元素，容易出现异常；
					//可以使用Iterator接口中的子接口ListIterator来完成在迭代中对元素进行更多的操作。
			if (obj.equals("abc2")) {
				list.add("abc9");
			}
			else {
				System.out.println("next:"+obj);
			}
		}
		System.out.println(list);*/
	}

}
