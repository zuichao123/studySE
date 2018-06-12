package cn.sunjian.instanceofs;

/**
 * instanceof�ؼ���
 * 
 * @author sunjian
 *
 */
class A{
	public String AUTHOR = "jack";
	public void fun1(){
		System.out.println("A:fun1()����");
	}
	public void fun2(){
		System.out.println("A:fun2()����");
	}
}
class B extends A {
	public void fun1(){
		System.out.println("B:fun1����");
	}
	public void fun3(){
		System.out.println("B:fun3����");
	}
}
class C extends A{
	public void fun1(){
		System.out.println("C:fun1����");
	}
	public void fun5(){
		System.out.println("C:fun5����");
	}
}



public class InstanceofDemo {

	public static void main(String[] args) {

		print(new B());
		print(new C());
	}
	
	/*
	 * ʹ��instanceof�ؼ��ֶԴ���Ķ�����������жϺ��ٵ���
	 */
	public static void print(A a){
		if (a instanceof B) {	
			a.fun1();
			B b = (B)a;//ǿ�ƽ������������ת��Ϊ��������
			b.fun3();
		}
		if (a instanceof C) {
			a.fun1();
			C c = (C)a;
			c.fun5();
		}
	}

}
