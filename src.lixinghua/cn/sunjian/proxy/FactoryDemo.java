package cn.sunjian.proxy;
/**
 * java反射机制：
 * 		
 * 		工厂设计模式：
 * 			
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
		
		return fruit;
	}
}


public class FactoryDemo {

	public static void main(String[] args) {

		Fruit f = Factory.getInstance("apple");
		
		f.eat();
	}

}
