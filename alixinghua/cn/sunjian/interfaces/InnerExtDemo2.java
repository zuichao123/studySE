package cn.sunjian.interfaces;
/**
 * �ڲ���չ��ģʽ
 * 
 * @author sunjian
 *
 */

/*
 * �ڽӿ��ж����ڲ�������
 */
interface AAAA{
	public void printA();//������󷽷�
	abstract class B{	//�����ڲ�������
		public abstract void printB();//������󷽷�
	}
}

class XXX implements AAAA{//ʵ�ֽӿ�
	public void printA(){
		System.out.println("Hello--->A");
	}
	class Y extends B{//�����ڲ���̳��ڲ�������
		public void printB(){
			System.out.println("Hello--->B");
		}
	}
}



public class InnerExtDemo2 {

	public static void main(String[] args) {
		AAAA a = new XXX();
		a.printA();
		
		AAAA.B b = new XXX().new Y();
		b.printB();
	}

}
