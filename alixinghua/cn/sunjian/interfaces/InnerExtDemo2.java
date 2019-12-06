package cn.sunjian.interfaces;
/**
 * 内部扩展类模式
 * 
 * @author sunjian
 *
 */

/*
 * 在接口中定义内部抽象类
 */
interface AAAA{
	public void printA();//定义抽象方法
	abstract class B{	//定义内部抽象类
		public abstract void printB();//定义抽象方法
	}
}

class XXX implements AAAA{//实现接口
	public void printA(){
		System.out.println("Hello--->A");
	}
	class Y extends B{//定义内部类继承内部抽象类
		public void printB(){
			System.out.println("Hello--->B");
		}
	}
}



public class InnerExtDemo2 {

	public static void main(String[] args) {
		AAAA a = new XXX();
		a.printA();
		
		AAAA.B b = new XXX().new Y();
		b.printB();
	}

}
