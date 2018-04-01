package cn.sunjian.innerclass;

/**
 * 内部类
 * 
 * @author sunjian
 *
 */


/*
 * 在方法中定义内部类：
 * 访问私有属性
 * 
 */
class Outer{
	
	private String info = "hello world!";
	
	public void fun(final int temp){
		class Inner{
			public void print(){
				System.out.println(info);
				System.out.println(temp);
			}
		}
		new Inner().print();
	}
}


public class InnerClassDemo {

	public static void main(String[] args) {
		
		Outer outer = new Outer();
		
		outer.fun(30);
		
	}

}
