package cn.sunjian.enumeration;

import java.util.EnumMap;
import java.util.Map;

/**
 * EnumMap类：
 * 	
 * 		输出
 * 		
 * @author jack
 *
 */
enum Color6{
	RED,GREEN,BLUE;
}

public class EnumMapDemo {

	public static void main(String[] args) {

		Map<Color6,String> desc = null;//定义Map对象，同时指定类型
		desc = new EnumMap<Color6,String>(Color6.class);
		
		
		desc.put(Color6.BLUE, "蓝色");
		desc.put(Color6.RED, "红色");
		desc.put(Color6.GREEN, "绿色");
	
		System.out.println("输出全部内容：");
		
		for(Color6 c6 : Color6.values()){
			System.out.print(c6.name()+"-->"+desc.get(c6)+"、");//根据枚举对象（key）找到枚举名（value）
		}
		
		System.out.println("\n输出全部键：");
		for(Color6 c66 : desc.keySet()){
			System.out.print(c66.name()+"、");
		}
		
		System.out.println("\n输出全部的值：");
		for(String c666 : desc.values()){
			System.out.print(c666+"、");
		}
	}

}
