package cn.sunjian.singleton;

/**
 * ����ģʽ
 * 
 * ���췽��˽�л�
 * 
 * @author sunjian
 *
 */

class Singleton{
	private Singleton(){}
	
	private static Singleton instance = new Singleton();
	
	public static Singleton getInstance(){
		return instance;
	}
	
	public void print(){
		System.out.println("����ģʽ");
	}
}

public class SingletonDemo {

	public static void main(String[] args) {
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		Singleton s3 = Singleton.getInstance();
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s1);
		s1.print();
		s2.print();
		s3.print();

	}

}
