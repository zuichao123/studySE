package cn.sunjian.interfaces;

/**
 * ��ϰ�ӿڵĶ�����ʵ��
 * �ӿڵĶ�̳�
 * 
 * @author sunjian
 *
 */

/*
 * �ӿ��е�����Ĭ�ϼ��У� static�ؼ���
 * ����ӿ�
 */
interface A3{
	public String AUTHOR = "jack";
	public void printa();
}
interface B3 {
	public void printb();
}
/*
 * �ӿڶ�̳к��ٱ�ʵ��
 */
interface C3 extends A3,B3{
	public void printc();
}
/*
 * ʵ�ֽӿ�
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
