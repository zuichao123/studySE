package cn.sunjian.innerclass;

/**
 * �ڲ���
 * 
 * @author sunjian
 *
 */


/*
 * �ڷ����ж����ڲ��ࣺ
 * ����˽������
 * 
 */
class Outer{
	
	private String info = "hello world!";
	
	public void fun(final int temp){
		class Inner{
			public void print(){
				System.out.println(info);
				System.out.println(temp);
			}
		}
		new Inner().print();
	}
}


public class InnerClassDemo {

	public static void main(String[] args) {
		
		Outer outer = new Outer();
		
		outer.fun(30);
		
	}

}
