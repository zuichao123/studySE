package cn.sunjian.interfaces;

/**
 * 练习接口的定义与实现
 * 抽象类实现接口后，再被继承
 * 
 * @author sunjian
 *
 */

/*
 * 接口中的属性默认加有： static关键字
 * 定义接口
 */
interface A2{
	public String AUTHOR = "jack";
	public void print();
	public String getInfo();
}
/*
 * 抽象类实现接口，再被继承
 */
abstract class B2 implements A2{
	public abstract void say();
}

/*
 * 子类继承父类
 */
class X2 extends B2 {
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


public class InterfaceDemo2 {

	public static void main(String[] args) {
		
		X2 x = new X2();
		System.out.println(x.getInfo());
		x.say();
		x.print();
		System.out.println(x.getClass());
	}

}
