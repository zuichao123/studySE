package cn.sunjian.interfaces;

/**
 * 练习接口的定义与实现
 * 
 * @author sunjian
 *
 */

/*
 * 接口中的属性默认加有： static关键字
 * 定义接口
 */
interface A{
	public String AUTHOR = "jack";
	public void print();
	public String getInfo();
}
abstract class B{
	public abstract void say();
}

/*
 * 子类继承父类后，再实现接口
 */
class X extends B implements A{
	public void print(){
		System.out.println("作者："+AUTHOR);
	}
	public String getInfo(){
		return "Hello";
	}
	public void say(){
		System.out.println("my name is jack!");
	}
}


public class InterfaceDemo {

	public static void main(String[] args) {
		
		X x = new X();
		System.out.println(x.getInfo());
		x.say();
		x.print();
		System.out.println(x.getClass());
	}

}
