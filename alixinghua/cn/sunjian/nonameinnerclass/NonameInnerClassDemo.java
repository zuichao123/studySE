package cn.sunjian.nonameinnerclass;

/**
 * 匿名内部类
 * 
 * @author sunjian
 *
 */
interface A{//定义抽象类
	public void printInfo();//定义抽象方法
}

class B{
	public void fun1(){
		this.fun2(new A() {//可以使用匿名内部类，实现接口中的抽象方法；传给fun2方法
						//因为只使用一次，所以可以使用匿名内部类
			@Override
			public void printInfo() {
				System.out.println("成功使用匿名内部类，覆写接口中的抽象方法");
			}
		});
	}
	public void fun2(A a){//调用接口中的printInfo方法
		a.printInfo();
	}
}


public class NonameInnerClassDemo {

	public static void main(String[] args) {
		B b = new B();
		b.fun1();
	}

}
