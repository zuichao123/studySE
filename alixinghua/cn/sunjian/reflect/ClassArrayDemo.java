package cn.sunjian.reflect;

import java.lang.reflect.Array;

/**
 * java反射机制：重点复习；
 * 
 * 		操作数组：
 * 			得到数组内容；
 * 			操作数组内容
 * 				修改内容；
 *			修改数组大小；
 *				修改的过程实际上就是一个创建的过程，创建一个新的数组，将旧的内容拷贝到新的数组中；；
 * 
 * @author jack
 *
 */
public class ClassArrayDemo {

	public static void main(String[] args) {
		
		int temp[] = {1,2,3};//声明一个整型数组
		
		/*
		 * 得到数组；
		 * 修改内容；
		 */
		Class<?> c = temp.getClass().getComponentType();//得到数组的Class对象
		System.out.println("类型："+c.getName());//取得数组类型名称
		System.out.println("长度："+Array.getLength(temp));//取得数组长度
		System.out.println("第一个内容："+Array.get(temp, 0));//第一个内容
		
		Array.set(temp, 0, 6);//修改第一个类的内容为“6”
		System.out.println("第一个内容："+Array.get(temp,0));//修改后的第一个内容
		
		/*
		 * 修改数组大小
		 */
		int newTemp[] = (int[]) arrayInc(temp, 6);
		print(newTemp);
		System.out.println("\n----------------------");
		String strArr[] = {"adfasf","adsfasdf","adsfasdf"};
		String newStrArr[] = (String[]) arrayInc(strArr, 8);
		print(newStrArr);
	}

	//修改数组方法
	public static Object arrayInc(Object obj,int len){
		Class<?> c = obj.getClass();//得到Class对象
		Class<?> arr = c.getComponentType();//得到数组的Class对象
		
		Object newO = Array.newInstance(arr, len);//开辟新的大小
		int co = Array.getLength(obj);//得到数组旧数组的长度
		System.arraycopy(obj, 0, newO, 0, co);//拷贝数组
		
		return newO;//返回新数组
	}
	
	//数组输出
	public static void print(Object obj){
		Class<?> cc = obj.getClass();//得到Class类的对象
		if (!cc.isArray()) {//如果不是数组
			return;
		}
		Class<?> arr = cc.getComponentType();//得到数组对象
		System.out.println(arr.getName()+"数组的长度："+Array.getLength(obj));
		for(int i=0;i<Array.getLength(obj);i++){
			System.out.print(Array.get(obj, i)+"、");
		}
	}
}
