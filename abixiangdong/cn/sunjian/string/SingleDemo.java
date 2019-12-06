package cn.sunjian.string;

/**
 * 单例模式涉及到的多线程问题
 * @author sunjian
 *
 */

//饿汉式
class Single1{
	private static Single1 s = new Single1();
	
	private Single1(){
		System.out.println("这是饿汉式，单例模式！");
	}
	
	public static Single1 getInstance(){
		return s;
	}
}



//懒汉式
class Single{
	private static Single s = null;
	
	private Single(){
		System.out.println("这是懒汉式，单例模式！");
	}
	
	public static Single getInstance(){
		//多加一个判断，可以解决效率问题
		if (s==null) {
			//加锁可以解决线程安全问题
			synchronized (Single.class) { //Single.class类的字节码对象
				if (s==null) {
					s = new Single();
				}
			}
		}
		return s;
	}
}





public class SingleDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Single1.getInstance();
		Single.getInstance();
	}

}
