package cn.sunjian.instanceofs;

/**
 * instanceof关键字
 * 
 * @author sunjian
 *
 */
class A{
	public String AUTHOR = "jack";
	public void fun1(){
		System.out.println("A:fun1()方法");
	}
	public void fun2(){
		System.out.println("A:fun2()方法");
	}
}
class B extends A {
	public void fun1(){
		System.out.println("B:fun1方法");
	}
	public void fun3(){
		System.out.println("B:fun3方法");
	}
}
class C extends A{
	public void fun1(){
		System.out.println("C:fun1方法");
	}
	public void fun5(){
		System.out.println("C:fun5方法");
	}
}



public class InstanceofDemo {

	public static void main(String[] args) {

		print(new B());
		print(new C());
	}
	
	/*
	 * 使用instanceof关键字对传入的对象参数进行判断后，再调用
	 */
	public static void print(A a){
		if (a instanceof B) {	
			a.fun1();
			B b = (B)a;//强制将父类对象，向下转型为子类引用
			b.fun3();
		}
		if (a instanceof C) {
			a.fun1();
			C c = (C)a;
			c.fun5();
		}
	}

}
