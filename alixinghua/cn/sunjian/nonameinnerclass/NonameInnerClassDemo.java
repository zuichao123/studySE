package cn.sunjian.nonameinnerclass;

/**
 * �����ڲ���
 * 
 * @author sunjian
 *
 */
interface A{//���������
	public void printInfo();//������󷽷�
}

class B{
	public void fun1(){
		this.fun2(new A() {//����ʹ�������ڲ��࣬ʵ�ֽӿ��еĳ��󷽷�������fun2����
						//��Ϊֻʹ��һ�Σ����Կ���ʹ�������ڲ���
			@Override
			public void printInfo() {
				System.out.println("�ɹ�ʹ�������ڲ��࣬��д�ӿ��еĳ��󷽷�");
			}
		});
	}
	public void fun2(A a){//���ýӿ��е�printInfo����
		a.printInfo();
	}
}


public class NonameInnerClassDemo {

	public static void main(String[] args) {
		B b = new B();
		b.fun1();
	}

}
