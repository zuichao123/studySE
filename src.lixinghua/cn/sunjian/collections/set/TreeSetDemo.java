package cn.sunjian.collections.set;

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
		
		allSet.add("D");
		allSet.add("A");
		allSet.add("E");
		allSet.add("B");
		allSet.add("C");
		allSet.add("C");
		
		System.out.println(allSet);
		
		/*
		 * ��������
		 */
		
	}

}
