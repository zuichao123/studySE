package cn.sunjian.otherapi;

import java.util.Random;

/**
 * Math: �ṩ�˲�����ѧ����ķ��������Ǿ�̬�ġ�
 * 
 * @author sunjian
 *
 */
public class MathDemo {

	public static void main(String[] args) {

		/*
		 * ���÷�����
		 * ceil();���ش��ڲ�������С����
		 * floor();����С�ڲ�������С����
		 * round();�����������������
		 * pow(a,b);a��b�η�
		 * random();�����
		 * 
		 */
		
		double d1 = Math.ceil(12.56);
		double d2 = Math.floor(12.56);
		double d3 = Math.round(12.56);
		
		sop("d1="+d1);
		sop("d2="+d2);
		sop("d3="+d3);
		
		double d = Math.pow(10, 2);
		sop("d="+d);
		
		Random r = new Random();
		for(int i=0; i<10; i++){
			double dd = (int)(Math.random()*6+1);
			double ddd = (int)(r.nextDouble()*6+1);
			int dddd = r.nextInt(6)+1;
//			System.out.println(dd);
//			System.out.println(ddd);
			System.out.println(dddd);
		}
		
	}

	public static void sop(String string) {
		System.out.println(string);
	}

}
