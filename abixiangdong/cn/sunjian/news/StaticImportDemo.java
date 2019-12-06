package cn.sunjian.news;

import java.util.ArrayList;
//import java.util.Collections;
import java.util.List;
import static java.util.Collections.*;
import static java.lang.System.*;
/**
 * 练习-静态导入
 * 
 * @author sunjian
 *
 */
public class StaticImportDemo {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("abc231");
		list.add("abc300");
		list.add("abc783");
		
		out.println(list);
		
		//排序
		sort(list);
		System.out.println(list);
		
		//取最大值
		String max = max(list);
		System.out.println(max);
	}

}
