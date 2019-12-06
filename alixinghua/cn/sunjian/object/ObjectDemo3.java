package cn.sunjian.object;
/**
 * Object 类练习
 * 
 * 使用Object接收数组
 * 
 * @author sunjian
 *
 */

public class ObjectDemo3 {

	public static void main(String[] args) {
		int temp[] = {1,2,5,7,9};
		Object obj = temp;//使用Object接收数组
		print(obj);
	}

	private static void print(Object obj) {
		//判断传入的object是否是整形数组
		if (obj instanceof int[]) {
			int x[] = (int[])obj;//将obj向下转型为int[]，并赋值给数组x
			for (int i = 0; i < x.length; i++) {//打印数组
				System.out.println(x[i]);
			}
		}
	}

}
