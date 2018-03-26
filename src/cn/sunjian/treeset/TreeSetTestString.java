package cn.sunjian.treeset;

import java.util.Iterator;
import java.util.TreeSet;

import cn.sunjian.compratator.ComparatorByLength;

/**
 * ²âÊÔ×Ö·û´®±È½ÏÆ÷
 * 
 * @author sunjian
 *
 */
public class TreeSetTestString {

	public static void main(String[] args) {

		TreeSet ts = new TreeSet(new ComparatorByLength());
		
		ts.add("abs");
		ts.add("m");
		ts.add("tbj");
		ts.add("eh");
		ts.add("icn");
		ts.add("sq");
		ts.add("uekz");
		ts.add("jkzlop");
		ts.add("poqskkz");
		ts.add("hfksdisdf");
		ts.add("jhgkz");
		
		Iterator it = ts.iterator();
		
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}

}
