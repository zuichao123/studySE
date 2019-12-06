package cn.sunjian.polymorphic;

/**
 * ��̬�Ե���ϰ
 * 
 * ����ת��+����ת��
 * 
 * @author sunjian
 *
 */

/*
 * ������A
 */
class A{
	public void fun1(){
		System.out.println("����A���fun1����");
	}
	public void fun2(){
		this.fun1();
	}
	public void fun5(){
		System.out.println("����A���е�fun5����");
	}
}

/*
 * ������B�̳���A
 */
class B extends A{
	public void fun1(){
		System.out.println("����B���е�fun1����");
	}
	public void fun3(){
		System.out.println("����B���е�fun3����");
	}
}
/*
 * ������C�̳�A
 */
class C extends A{
	public void fun1(){
		System.out.println("����C���е�fun1����");
	}
	public void fun4(){
		System.out.println("����C���е�fun4����");
	}
}



public class PolymorphicDemo {

	public static void main(String[] args) {
		print(new B());
		print(new C());
	}
	/*
	 * �ø��������ȥ���գ������ʵ��������
	 * (����ת��)
	 * �˷�ʽ��ֻҪ�������еķ����Ϳ��Ե��ã�������õ���
	 * ���าд���ģ��͵�������ģ����û�и�д���ľ͵��ø����
	 */
	public static void print(A a){
		a.fun1();
	}

}
