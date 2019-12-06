package cn.sunjian.proxy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * java反射机制：
 * 		
 * 		工厂设计模式：扩充操作练习
 * 			普通方式（最简单的工厂设计模式）；
 * 			通过反射完成，扩充子类时，不用去修改工厂类；
 * 				通过配置文件的方式保存这些完整的路径；
 * 
 * @author jack
 *
 */
interface Fruit{
	public void eat();//抽象方法（吃）
}

class Apple implements Fruit{
	public void eat(){
		System.out.println("吃苹果。。。。。。。");
	}
}
class Orange implements Fruit{
	public void eat(){
		System.out.println("吃橘子。。。。。。。");
	}
}

class Factory{
	public static Fruit getInstance(String className){
		
		Fruit fruit = null;
		
		if ("apple".equals(className)) {
			fruit = new Apple();
		}
		if ("orange".equals(className)) {
			fruit = new Orange();
		}
		
		/*
		 * 通过反射完成，扩充子类时，不用去修改工厂类
		 * 
		 * 以上是一个最简单的工厂设计模式，但是这样的代码存在问题：
		 * 	如果现在扩充了一个子类，则肯定要修改工厂类。
		 * 如果此时希望在扩充子类时不用修改工厂类的话，则就必须使用反射完成。
		 */
		
		try {
			fruit = (Fruit) Class.forName(className).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		/*
		 * 通过反射完成，扩充子类时，不用去修改工厂类（通过配置文件的方式保存这些完整的路径；）
		 * 	
		 * 以上的程序代码中依然存在问题，在使用的时候输入完整的“包.类”名称的话，肯定很麻烦，所有可以通过
		 * 一些配置文件的方式保存这些完整的路径。	
		 * 
		 */
		
		return fruit;
	}
}

/*
 * 通过配置文件方式读取类文件的路径信息
 */
class Init{
	public static Properties getPro(){//得到配置文件
		
		Properties pro = new Properties();
		File file = new File(System.getProperty("user.dir")+"\\src.lixinghua\\cn\\sunjian\\proxy\\config.properties");//找到属性文件
		
		if (file.exists()) {
			try {
				pro.load(new FileInputStream(file));//读取配置文件
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			pro.setProperty("apple", "cn.sunjian.proxy.Apple");//设置内容
			pro.setProperty("orange", "cn.sunjian.proxy.Orange");
			
			try {
				pro.store(new FileOutputStream(file), "Fruit Class");//将设置的内容写入配置文件
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return pro;
	}
	/*
	 * 以上的程序达到了配置文件与程序代码相分离的目的；
	 * 那么这种设计思路时以后开发的基本思路；
	 * 当然，最新的设计理念：是在程序中直接通过注释的方式进行配置；
	 */
}


public class FactoryDemo {

	public static void main(String[] args) {
		
		Properties pro = Init.getPro();
		
//		Fruit f = Factory.getInstance("apple");//普通调用
//		Fruit f = Factory.getInstance("cn.sunjian.proxy.Orange");//反射调用时，需传入类名称
		Fruit f = Factory.getInstance(pro.getProperty("apple"));//通过配置文件调用
		if (f != null) {			
			f.eat();
		}
	}

}
