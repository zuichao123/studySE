package cn.sunjian.proxy;

import cn.sunjian.p.bean.Person;

/**
 * java������ƣ���̬����
 * 
 * 		��������
 * 			�õ�������
 * 
 * @author jack
 *
 */
public class ClassLoaderDemo {

	public static void main(String[] args) {

		Person stu = new Person();
		System.out.println("���������"+stu.getClass().getClassLoader().getClass().getName());
	}

}
