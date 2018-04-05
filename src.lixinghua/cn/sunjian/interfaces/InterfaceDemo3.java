package cn.sunjian.interfaces;

/**
 * 练习接口的定义与实现
 * 接口的多继承
 * 
 * @author sunjian
 *
 */

/*
 * 接口中的属性默认加有： static关键字
 * 定义接口
 */
interface A3{
	public String AUTHOR = "jack";
	public void printa();
}
interface B3 {
	public void printb();
}
/*
 * 接口多继承后，再被实现
 */
interface C3 extends A3,B3{
	public void printc();
}
/*
 * 实现接口
 */
class X3 implements C3{
	public void printa(){
		System.out.println("A");
	}
	public void printb(){
		System.out.println("B");
	}
	public void printc(){
		System.out.println("C");
	}
}

public class InterfaceDemo3 {

	public static void main(String[] args) {
		
		X3 x = new X3();
		x.printa();
		x.printb();
		x.printc();
		
		System.out.println(A3.AUTHOR);
	}

}
