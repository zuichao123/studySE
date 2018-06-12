package cn.sunjian.bigdecimal;

import java.math.BigDecimal;

/**
 * BigDecimal�������ϰ����С��
 * 	
 * @author sunjian
 *
 */
class MyMath{
	public static double add(double d1,double d2){//�ӷ�
		BigDecimal b1 = new BigDecimal(d1);
		BigDecimal b2 = new BigDecimal(d2);
		
		return b1.add(b2).doubleValue();
	}
	public static double sub(double d1,double d2){//��������
		BigDecimal b1 = new BigDecimal(d1);
		BigDecimal b2 = new BigDecimal(d2);

		return b1.subtract(b2).doubleValue();
	}
	public static double mul(double d1,double d2){//�˷�
		BigDecimal b1 = new BigDecimal(d1);
		BigDecimal b2 = new BigDecimal(d2);

		return b1.multiply(b2).doubleValue();
	}
	public static double div(double d1,double d2,int len){//����,��ָ������С������λ��
		BigDecimal b1 = new BigDecimal(d1);
		BigDecimal b2 = new BigDecimal(d2);

		return b1.divide(b2, len,BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	public static double round(double d,int len){//��������,��ָ����С�����ĸ���
		BigDecimal b1 = new BigDecimal(d);
		BigDecimal b2 = new BigDecimal(1);
		
		return b1.divide(b2, len,BigDecimal.ROUND_HALF_UP).doubleValue();
	}
}

public class BigDecimalDemo {

	public static void main(String[] args) {
	
		System.out.println("�ӷ���"+MyMath.add(10.345, 3.333));
		System.out.println("������"+MyMath.sub(10.345, 3.333));
		System.out.println("�˷���"+MyMath.mul(10.345, 3.333));
		System.out.println("������"+MyMath.div(10.345, 3.333,3));
		System.out.println("�������룺"+MyMath.round(10.345,2));
		
	}

}
