package cn.sunjian.toolclass_arrays;

import java.util.Arrays;
import java.util.List;

/**
 * ���Ͽ�ܵĹ�����===Arrays
 * @author sunjian
 *
 */
public class ArraysDemo {

	public static void main(String[] args) {

		/**
		 * �ص㣺List asList�����飩������ת�ɼ��ϡ�
		 * 
		 * �ô�����ʵ����ʹ�ü��ϵķ������������е�Ԫ�ء�
		 * ע�⣺����ĳ����ǹ̶��ģ����Զ��ڼ��ϵ���ɾ�����ǲ�����ʹ�õģ�����ᷢ��UnsupportedOperationException
		 * 
		 */
		
		String [] arr = {"abc","haha","xixi"};
		
		List<String> list = Arrays.asList(arr);
		
		System.out.println(list);
		
		int[] arr1 = {42,45,83,90};
		demo_1(arr1);
		
	}

	private static void demo_1(int[] arr1) {
		List<int[]> list = Arrays.asList(arr1);
		System.out.println(list);
	}

}
