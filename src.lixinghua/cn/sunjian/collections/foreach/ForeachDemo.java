package cn.sunjian.collections.foreach;

import java.util.ArrayList;
import java.util.List;

/**
 * foreach操作练习：
 * 
 * 		循环输出
 * 
 * @author jack
 *
 */
public class ForeachDemo {

	public static void main(String[] args) {

		List<String> allList = new ArrayList<String>();
		
		allList.add("hello");
		allList.add("_");
		allList.add("world");
		
		for(String str : allList){
			System.out.print(str+"、");//输出内容
		}
	}

}
