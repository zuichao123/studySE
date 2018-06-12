package cn.sunjian.interfaces;

/**
 * ��ϰ�ӿڵĶ�����ʵ��
 * ������ʵ�ֽӿں��ٱ��̳�
 * 
 * @author sunjian
 *
 */

/*
 * �ӿ��е�����Ĭ�ϼ��У� static�ؼ���
 * ����ӿ�
 */
interface A2{
	public String AUTHOR = "jack";
	public void print();
	public String getInfo();
}
/*
 * ������ʵ�ֽӿڣ��ٱ��̳�
 */
abstract class B2 implements A2{
	public abstract void say();
}

/*
 * ����̳и���
 */
class X2 extends B2 {
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


public class InterfaceDemo2 {

	public static void main(String[] args) {
		
		X2 x = new X2();
		System.out.println(x.getInfo());
		x.say();
		x.print();
		System.out.println(x.getClass());
	}

}
