package cn.sunjian.wrapperclass;

/**
 * ��ϵ��װ���ʹ��
 * 
 * @author sunjian
 *
 */
public class WrapperClassDemo {

	public static void main(String[] args) {
		
		int num;
		
//		System.out.println(Integer.MAX_VALUE);
//		System.out.println(Integer.toBinaryString(-6));
		
		int num1 = 4 ;
		
		num1 += 5;
		
		Integer i = 4;
		i = i + 6;
		
		show(55);
		
		
		Integer a = new Integer(128);
		Integer b = new Integer(128);
		
		System.out.println(a==b);//false
		System.out.println(a.equals(b));//true
		
		Integer x = 127;
		Integer y = 127;
		
		System.out.println(x==y);//true,jdk1.5�Ժ��Զ�װ�䣬���װ�����һ���ֽڣ���ô�����ݻᱻ���������¿��ٿռ䡣
		System.out.println(x.equals(y));//true
	}

	public static void show(Object a) {
		System.out.println("a="+a);
	}

}
