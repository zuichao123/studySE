package cn.sunjian.arraylist.test;

import java.util.ArrayList;
import java.util.Iterator;

import cn.sunjian.p.bean.Person;

/**
 * ��һ�������е�Ԫ�أ�ȡΨһֵ����������һ��������
 * 
 * ˼·��
 * 1.���������е�Ԫ��
 * 2.�������жϵ�ǰԪ���Ƿ����µ������д��ڣ�����ڲ��洢���粻���ڣ��洢
 * 
 * @author sunjian
 *
 */
public class ArrayListTest2 {

	public static void main(String[] args) {
		
		singleDemo();
		
		ArrayList<Person> al = new ArrayList<Person>();
		
		al.add(new Person("lisi1",21));
		al.add(new Person("lisi2",22));
		al.add(new Person("lisi1",21));
		al.add(new Person("lisi3",23));
		al.add(new Person("lisi4",24));
		al.add(new Person("lisi2",22));
		al.add(new Person("lisi3",23));

		
		
		System.out.println(al);//��ӡ��ǰ����Ԫ��
		
		al = getSingleElement(al);

		Person per = null;
		Iterator<Person> iterator = al.iterator();
		
		System.out.print("[");
		while(iterator.hasNext()){
			per = iterator.next();
			//��ӡȥ�غ������Ԫ��
			System.out.print(per+", ");
		}
		System.out.print("]");
		
	}

	/**
	 * 
	 */
	public static void singleDemo() {
		
		ArrayList al = new ArrayList();
		al.add("abc1");
		al.add("abc2");
		al.add("abc1");
		al.add("abc7");
		al.add("abc8");
		al.add("abc3");
		al.add("abc7");
		
		System.out.println(al);//��ӡ��ǰ����Ԫ��
		
		//ȥ������Ԫ��
		al = getSingleElement(al);
		
		System.out.println(al);//��ӡȥ�غ������
	}

	public static ArrayList getSingleElement(ArrayList al) {
		
		//����һ��������
		ArrayList temp = new ArrayList();
		
		//����������;���ж����������Ƿ������ǰԪ�أ��粻�������ʹ洢��������Ͳ��洢
		Iterator it = al.iterator();
		while(it.hasNext()){
			Object obj = it.next();		
			if (!temp.contains(obj)) {				
				temp.add(obj);
			}
		}
		
		return temp;
	}

}
