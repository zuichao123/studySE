package cn.sunjian.interfaces;
/**
 * �ڲ���չ��ģʽ
 * 
 * @author sunjian
 *
 */

/*
 * �ڳ������ж����ڲ��ӿ�
 */
abstract class AAA{
	public abstract void printA();//������󷽷�
	interface B{	//�����ڲ��ӿ�
		public void printB();//������󷽷�
	}
}

class XX extends AAA{//�̳г�����
	public void printA(){
		System.out.println("Hello--->A");
	}
	class Y implements B{//�����ڲ���ʵ���ڲ��ӿ�
		public void printB(){
			System.out.println("Hello--->B");
		}
	}
}



public class InnerExtDemo {

	public static void main(String[] args) {
		XX x = new XX();
		x.printA();
		
		XX.Y xx = new XX().new Y();
		xx.printB();
	}

}
