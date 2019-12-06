package cn.sunjian.enumeration;

import java.util.EnumSet;

/**
 * EnumSet类：
 * 	
 * 		1.将全部的集合设置到EnumSet集合之中==allOf
 * 		2.将枚举的一个类型设置到EnumSet对象中==of
 * 		3.同时有多个类型的枚举对象，但是一个集合中只要求放入指定类型的枚举==noneOf
 * 		4，还可以创建不包含指定类型的集合==complementOf
 * 		5.拷贝一个集合的内容
 * 		
 * @author jack
 *
 */
enum Color7{
	RED,GREEN,BLUE;
}

public class EnumSetDemo {

	public static void main(String[] args) {

		EnumSet<Color7> es = null;//声明一个EnumSet对象
		EnumSet<Color7> esNew = null;//声明一个EnumSet对象
		
		System.out.println("--------EnumSet.allOf(Color.class)将枚举的全部类型设置到EnumSet对象中：");
		//1.将枚举的全部类型设置到EnumSet对象中
		es = EnumSet.allOf(Color7.class);
		print(es);
		
		
		System.out.println("\n--------EnumSet.of(Color.BLUE)将枚举的一个类型设置到EnumSet对象中：");
		//2.将枚举的一个类型设置到EnumSet对象中
		es = EnumSet.of(Color7.BLUE);
		print(es);
		
		System.out.println("\n--------EnumSet.noneOf(Color.class)创建一个可以接收指定类的空集合：");
		//3.创建一个可以接收指定类的空集合
		es = EnumSet.noneOf(Color7.class);
		es.add(Color7.BLUE);//添加内容
		es.add(Color7.GREEN);
		print(es);

		System.out.println("\n--------EnumSet.complementOf(Color.class)创建一个不包含指定类型的集合：");
		//4.创建一个不包含指定类型的集合
		es = EnumSet.noneOf(Color7.class);
		es.add(Color7.BLUE);//添加内容
		es.add(Color7.GREEN);
		
		esNew = EnumSet.complementOf(es);//不包含指定内容
		print(esNew);

		System.out.println("\n--------EnumSet.copyOf(Color.class)拷贝一个集合的内容：");
		//5.拷贝一个集合的内容
		es = EnumSet.noneOf(Color7.class);
		es.add(Color7.BLUE);//添加内容
		es.add(Color7.GREEN);
		
		esNew = EnumSet.copyOf(es);//将已有的内容拷贝过来
		print(esNew);
		
		
		
		
	}

	public static void print(EnumSet<Color7> es) {

		for(Color7 c7:es){
			System.out.print(c7+"、");
		}
	}

}
