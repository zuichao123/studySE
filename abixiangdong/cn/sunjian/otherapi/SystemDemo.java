package cn.sunjian.otherapi;

import java.util.Properties;
import java.util.Set;

/**
 * System类的方法和属性都是静态的
 * 
 * @author sunjian
 *
 */
public class SystemDemo {
	/*
	 * 常见方法
	 * long currentTimeMillis();获取当前时间的毫秒值
	 * 
	 */

	public static void main(String[] args) {
		long l1 = System.currentTimeMillis();
		System.out.println(l1);
		long l2 = System.currentTimeMillis();
		System.out.println(l2);
		
		//根据操作系统换行符
		System.out.println("hello-"+System.getProperty("line.separator")+"world");
		demo_1();
	}
	
	public static void demo_1(){
		/**
		 * 获取系统的属性信息，并存储到Properties集合中
		 * 
		 * properties集合中存储的都是String类型的键和值
		 * 最好使用它自己的存储和取出的方法来完成元素的操作。
		 * 
		 */
		Properties prop = System.getProperties();
		
		Set<String> nameSet = prop.stringPropertyNames();
		
		for(String name : nameSet){
			String value = prop.getProperty(name);
			System.out.println(name+"::"+value);
		}
	}
}
