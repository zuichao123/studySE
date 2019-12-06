package cn.sunjian.proxy;

import cn.sunjian.p.bean.Person;

/**
 * java反射机制：动态代理：
 * 
 * 		加载器；
 * 			得到加载器
 * 
 * @author jack
 *
 */
public class ClassLoaderDemo {

	public static void main(String[] args) {

		Person stu = new Person();
		System.out.println("类加载器："+stu.getClass().getClassLoader().getClass().getName());
	}

}
