package cn.sunjian.hasteset;

import java.util.HashSet;
import java.util.Iterator;

/**
 * ��ϰ hashset
 * 
 * @author sunjian
 *
 */
public class HashSetDemo {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		HashSet hs = new HashSet();
		
		hs.add("hehe");
		hs.add("heihei");
		hs.add("hehe");
		hs.add("heiheih");
		hs.add("heiheih");
		hs.add("heiheih");
		
		Iterator it = hs.iterator();
		
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
	}

}
