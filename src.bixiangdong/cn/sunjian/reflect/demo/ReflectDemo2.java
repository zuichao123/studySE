package cn.sunjian.reflect.demo;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import cn.sunjian.reflect.demo.bean.Person;

/**
 *
 */

public class ReflectDemo2 {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {

		createNewObject_2();
	}
	
	
	public static void createNewObject_2() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
//		cn.sunjian.reflect.demo.bean.Person p = new cn.sunjian.reflect.demo.bean.Person();
		
		/*
		 * 当获取指定名称对应类中的所体现的对象时，
		 * 而该对象初始化不使用空参数构造函数该怎么办呢？
		 * 既然是通过指定的构造函数进行对象的初始化。
		 * 所以应该先获取到该构造函数。通过字节码文件对象即可完成。
		 * 该方法是：getConstructor(paramterTypes);
		 *
		 */
		
		String name = "cn.sunjian.reflect.demo.bean.Person";
		//找寻该名称类文件，并加载进内存，并产生Class对象。
		Class clazz = Class.forName(name);
		//获取到了指定的构造函数对象。
		Constructor constructor = clazz.getConstructor(String.class,int.class);
		
		//通过该构造器对象的newInstance方法进行对象的初始化。
		Object obj = constructor.newInstance("小明",39);
		
		
		
	}


	public static void createNewObject() throws ClassNotFoundException, InstantiationException, IllegalAccessException{
		
		//早期：new的时候，先根据被new的类的名称找寻该类的字节码文件，并加载进内场，并创建该字节码文件对象，并接着创建该字节码文件对应的Person对象。
//		cn.sunjian.reflect.demo.bean.Person p = new cn.sunjian.reflect.demo.bean.Person();
		
		//现在：
		String name = "cn.sunjian.reflect.demo.bean.Person";
		//找寻该名称类文件，并加载进内场，并产生class对象。
		Class clazz = Class.forName(name);
		//如何产生该类的对象呢？
		Object obj = clazz.newInstance();
		
	}
	
}
