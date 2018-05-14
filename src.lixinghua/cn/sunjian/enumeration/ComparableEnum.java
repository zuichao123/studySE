package cn.sunjian.enumeration;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * 枚举：
 * 		排序
 * 
 * @author jack
 *
 */
enum Color5{
	RED,GREEN,BLUE;
}
public class ComparableEnum {

	public static void main(String[] args) {

		Set<Color5> t = new TreeSet<Color5>();//设置类型
		
		t.add(Color5.GREEN);//加入绿色
		t.add(Color5.RED);//加入红色
		t.add(Color5.BLUE);//加入蓝色
		
		Iterator<Color5> iterator = t.iterator();
		while(iterator.hasNext()){
			System.out.print(iterator.next()+"、");
		}
	}

}
