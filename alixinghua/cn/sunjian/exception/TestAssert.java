package cn.sunjian.exception;

/**
 * ����
 * 
 * @author sunjian
 *
 */
public class TestAssert {

	public static void main(String[] args) {
		int x[] = {1,2,3};
		
		if (!asserts(x)) {
			System.out.println("���鳤�Ȳ�Ϊ0");
		}else {			
			System.out.println("���鳤��Ϊ0");
		}
	}
	
	public static boolean asserts(int[] i){
		if (i instanceof int[]) {
			assert i.length == 0 : "���鳤�Ȳ�Ϊ0";//��������ĳ���Ϊ0
			return false;
		}else {
			return true;
		}
	}

}
