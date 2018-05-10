package cn.sunjian.collections.set;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * SortedSet�ӿڣ���ϰ
 * 
 * 		��ϰSortedSet�ӿ��еķ���
 * 
 * @author jack
 *
 */
public class SortedSetDemo {

	public static void main(String[] args) {

		SortedSet<String> allSet = new TreeSet<String>();
		
		allSet.add("A");
		allSet.add("B");
		allSet.add("C");
		allSet.add("C");
		allSet.add("C");
		allSet.add("D");
		allSet.add("E");
		
		System.out.println("��һ��Ԫ�أ�"+allSet.first());
		System.out.println("���һ��Ԫ�أ�"+allSet.last());
		System.out.println("headSetԪ�أ�"+allSet.headSet("C"));//�ӡ�c��֮ǰ��Ԫ��
		System.out.println("tailSetԪ�أ�"+allSet.tailSet("C"));//�ӡ�C��֮���Ԫ��
		System.out.println("subSetԪ�أ�"+allSet.subSet("B", "D"));//��B������D��֮���Ԫ��
	}

}
