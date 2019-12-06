package cn.sunjian.polymorphic;

/**
 * 多态性的练习
 * 
 * 向上转型+向下转型
 * 
 * @author sunjian
 *
 */

/*
 * 定义类A
 */
class A{
	public void fun1(){
		System.out.println("我是A类的fun1方法");
	}
	public void fun2(){
		this.fun1();
	}
	public void fun5(){
		System.out.println("我是A类中的fun5方法");
	}
}

/*
 * 定义类B继承类A
 */
class B extends A{
	public void fun1(){
		System.out.println("我是B类中的fun1方法");
	}
	public void fun3(){
		System.out.println("我是B类中的fun3方法");
	}
}
/*
 * 定义类C继承A
 */
class C extends A{
	public void fun1(){
		System.out.println("我是C类中的fun1方法");
	}
	public void fun4(){
		System.out.println("我是C类中的fun4方法");
	}
}



public class PolymorphicDemo {

	public static void main(String[] args) {
		print(new B());
		print(new C());
	}
	/*
	 * 用父类的引用去接收，子类的实例化对象
	 * (向上转型)
	 * 此方式，只要父类中有的方法就可以调用，如果调用的是
	 * 子类覆写过的，就调用子类的；如果没有覆写过的就调用父类的
	 */
	public static void print(A a){
		a.fun1();
	}

}
