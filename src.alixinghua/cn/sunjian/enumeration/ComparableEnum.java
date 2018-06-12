package cn.sunjian.enumeration;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * ö�٣�
 * 		����
 * 
 * @author jack
 *
 */
enum Color5{
	RED,GREEN,BLUE;
}
public class ComparableEnum {

	public static void main(String[] args) {

		Set<Color5> t = new TreeSet<Color5>();//��������
		
		t.add(Color5.GREEN);//������ɫ
		t.add(Color5.RED);//�����ɫ
		t.add(Color5.BLUE);//������ɫ
		
		Iterator<Color5> iterator = t.iterator();
		while(iterator.hasNext()){
			System.out.print(iterator.next()+"��");
		}
	}

}
