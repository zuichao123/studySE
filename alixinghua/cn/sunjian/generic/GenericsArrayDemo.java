package cn.sunjian.generic;
/**
 * �����������ϰ
 * 	
 * @author sunjian
 *
 */

public class GenericsArrayDemo {

	public static void main(String[] args) {
		Integer i[] = fun1(1,2,3,4);//���ط�������
		
		fun2(i);
		
	}
	
	public static <T> T[] fun1(@SuppressWarnings("unchecked") T...arg){//���տɱ����
		return arg;					//���ط�������
	}
	
	public static <T> void fun2(T param[]){//�������
		System.out.println("���շ�������:");
		
		for(T t:param){
			System.out.print(t+"��");
		}
	}

}
