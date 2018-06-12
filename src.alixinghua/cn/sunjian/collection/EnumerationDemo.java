package cn.sunjian.collection;

import java.util.Enumeration;
import java.util.Vector;

/**
 * Enumeration操作练习：
 * 
 * 		循环输出
 * 
 * @author jack
 *
 */
public class EnumerationDemo {

	public static void main(String[] args) {

		Vector<String> allList = new Vector<String>();
		
		allList.add("hello");
		allList.add("_");
		allList.add("world");
		
		Enumeration<String> enu = allList.elements();
		
		while(enu.hasMoreElements()){//判断是否有内容
			System.out.println(enu.nextElement());//输出内容
		}
	}

}
