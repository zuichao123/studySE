package cn.sunjian.collections;

import java.util.Set;
import java.util.TreeSet;

/**
 * Set�ӿڣ����ݲ����ظ�
 * 
 * 		TreeSet����
 * 			������
 * 
 * @author jack
 *
 */
public class TreeSetDemo {

	public static void main(String[] args) {

		Set<String> allSet = new TreeSet<String>();
		
		allSet.add("A");
		allSet.add("B");
		allSet.add("C");
		allSet.add("C");
		allSet.add("D");
		allSet.add("E");
		
		System.out.println(allSet);
		
	}

}
