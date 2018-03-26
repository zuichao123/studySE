package cn.sunjian.compratator;

import java.util.Comparator;
/**
 * 定义一个字符串的比较器
 * 
 * 比较字符串的长度，如果长度不同，按长度排序，如果长度相同，按字符字典顺序排序
 * 
 * @author sunjian
 *
 */
public class ComparatorByLength implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		
		String s1 = (String) o1;
		String s2 = (String) o2;
		
		int temp = s1.length()-s2.length();
		
		return temp==0?s1.compareTo(s2):temp;
	}
	
}
