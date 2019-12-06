package cn.sunjian.interfaces;
/**
 * 内部扩展类模式
 * 
 * @author sunjian
 *
 */

/*
 * 在抽象类中定义内部接口
 */
abstract class AAA{
	public abstract void printA();//定义抽象方法
	interface B{	//定义内部接口
		public void printB();//定义抽象方法
	}
}

class XX extends AAA{//继承抽象类
	public void printA(){
		System.out.println("Hello--->A");
	}
	class Y implements B{//定义内部类实现内部接口
		public void printB(){
			System.out.println("Hello--->B");
		}
	}
}



public class InnerExtDemo {

	public static void main(String[] args) {
		XX x = new XX();
		x.printA();
		
		XX.Y xx = new XX().new Y();
		xx.printB();
	}

}
