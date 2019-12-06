package cn.sunjian.enumeration;

import java.util.EnumSet;

/**
 * EnumSet�ࣺ
 * 	
 * 		1.��ȫ���ļ������õ�EnumSet����֮��==allOf
 * 		2.��ö�ٵ�һ���������õ�EnumSet������==of
 * 		3.ͬʱ�ж�����͵�ö�ٶ��󣬵���һ��������ֻҪ�����ָ�����͵�ö��==noneOf
 * 		4�������Դ���������ָ�����͵ļ���==complementOf
 * 		5.����һ�����ϵ�����
 * 		
 * @author jack
 *
 */
enum Color7{
	RED,GREEN,BLUE;
}

public class EnumSetDemo {

	public static void main(String[] args) {

		EnumSet<Color7> es = null;//����һ��EnumSet����
		EnumSet<Color7> esNew = null;//����һ��EnumSet����
		
		System.out.println("--------EnumSet.allOf(Color.class)��ö�ٵ�ȫ���������õ�EnumSet�����У�");
		//1.��ö�ٵ�ȫ���������õ�EnumSet������
		es = EnumSet.allOf(Color7.class);
		print(es);
		
		
		System.out.println("\n--------EnumSet.of(Color.BLUE)��ö�ٵ�һ���������õ�EnumSet�����У�");
		//2.��ö�ٵ�һ���������õ�EnumSet������
		es = EnumSet.of(Color7.BLUE);
		print(es);
		
		System.out.println("\n--------EnumSet.noneOf(Color.class)����һ�����Խ���ָ����Ŀռ��ϣ�");
		//3.����һ�����Խ���ָ����Ŀռ���
		es = EnumSet.noneOf(Color7.class);
		es.add(Color7.BLUE);//�������
		es.add(Color7.GREEN);
		print(es);

		System.out.println("\n--------EnumSet.complementOf(Color.class)����һ��������ָ�����͵ļ��ϣ�");
		//4.����һ��������ָ�����͵ļ���
		es = EnumSet.noneOf(Color7.class);
		es.add(Color7.BLUE);//�������
		es.add(Color7.GREEN);
		
		esNew = EnumSet.complementOf(es);//������ָ������
		print(esNew);

		System.out.println("\n--------EnumSet.copyOf(Color.class)����һ�����ϵ����ݣ�");
		//5.����һ�����ϵ�����
		es = EnumSet.noneOf(Color7.class);
		es.add(Color7.BLUE);//�������
		es.add(Color7.GREEN);
		
		esNew = EnumSet.copyOf(es);//�����е����ݿ�������
		print(esNew);
		
		
		
		
	}

	public static void print(EnumSet<Color7> es) {

		for(Color7 c7:es){
			System.out.print(c7+"��");
		}
	}

}
