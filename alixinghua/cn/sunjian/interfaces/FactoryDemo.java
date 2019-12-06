package cn.sunjian.interfaces;

/**
 * 工厂设计模式
 * 
 * @author sunjian
 *
 */
interface Fruit{//定义一个水果接口
	public void eat();//定义抽象方法（吃水果）
}

class Apple implements Fruit{
	public void eat(){
		System.out.println("吃苹果。。。");
	}
}
class Orange implements Fruit{
	public void eat(){
		System.out.println("吃橘子。。。");
	}
}

/*
 * 工厂类
 */
class Factory{
	public static Fruit getInstance(String className){
		Fruit f = null;
		if ("apple".equals(className)) {
			f = new Apple();
		}
		if ("orange".equals(className)) {
			f = new Orange();
		}
		return f;
	}
}

public class FactoryDemo {

	public static void main(String[] args) {
		//实例化对象（接口父类的引用，指向子类的对象）
//		Fruit f = Factory.getInstance(args[0]);
		Fruit f = Factory.getInstance("orange");
		if (f!=null) {			
			f.eat();
		}
	}

}
