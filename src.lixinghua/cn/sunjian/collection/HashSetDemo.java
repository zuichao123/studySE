package cn.sunjian.collection;

import java.util.HashSet;
import java.util.Set;

/**
 * Set�ӿڣ����ݲ����ظ�
 * 
 * 		HashSet����
 * 			ɢ�д��
 * 
 * @author jack
 *
 */
public class HashSetDemo {

	public static void main(String[] args) {

		Set<String> allSet = new HashSet<String>();
		
		allSet.add("A");
		allSet.add("B");
		allSet.add("C");
		allSet.add("C");
		allSet.add("D");
		allSet.add("E");
		
		System.out.println(allSet);
		
		/*
		 * [A, B, C, D, E]
		 * 
		 * ���������еģ���List�ӿڵ����ݲ����˳������䱣���˳���������ϣ�����е����ݿ����Զ���������Ĳ����������ʹ��Set�еĵڶ�������---->TreeSet��
		 */
		
	}

}
