package cn.sunjian.toolclass_arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ����ת������
 * ʹ�õľ���Collection�ӿ��е�toArray������
 * ����ת�����飺���ԶԼ����е�Ԫ�ز����ķ��������޶�����������������ɾ��
 * 
 * @author sunjian
 *
 */
public class CollectionToArray {

	public static void main(String[] args) {
		
		List<String> list = new ArrayList<String>();
		list.add("abc1");
		list.add("abc2");
		list.add("abc8");
		list.add("abc4");
		
		String[] arr = list.toArray(new String[list.size()]);
		
		System.out.println(Arrays.toString(arr));
	}

}
