package cn.sunjian.exception;

/**
 * 断言
 * 
 * @author sunjian
 *
 */
public class TestAssert {

	public static void main(String[] args) {
		int x[] = {1,2,3};
		
		if (!asserts(x)) {
			System.out.println("数组长度不为0");
		}else {			
			System.out.println("数组长度为0");
		}
	}
	
	public static boolean asserts(int[] i){
		if (i instanceof int[]) {
			assert i.length == 0 : "数组长度不为0";//断言数组的长度为0
			return false;
		}else {
			return true;
		}
	}

}
