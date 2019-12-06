package cn.sunjian.interfaces;

/**
 * ��ϰ�ӿڵĶ�����ʵ��
 * 
 * @author sunjian
 *
 */

/*
 * �ӿ��е�����Ĭ�ϼ��У� static�ؼ���
 * ����ӿ�
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
 * ����̳и������ʵ�ֽӿ�
 */
class X extends B implements A{
	public void print(){
		System.out.println("���ߣ�"+AUTHOR);
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
