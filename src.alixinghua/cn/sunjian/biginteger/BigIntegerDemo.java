package cn.sunjian.biginteger;

import java.math.BigInteger;

/**
 * BigInteger�������ϰ��������
 * 
 * @author sunjian
 *
 */
public class BigIntegerDemo {

	public static void main(String[] args) {
		BigInteger bi1 = new BigInteger("123456789");//����BigInteger����
		BigInteger bi2 = new BigInteger("987654321");//����BigInteger����
	
		System.out.println("�ӷ�������"+bi2.add(bi1));
		System.out.println("����������"+bi2.subtract(bi1));
		System.out.println("�˷�������"+bi2.multiply(bi1));
		System.out.println("����������"+bi2.divide(bi1));
		System.out.println("�������"+bi2.max(bi1));
		System.out.println("��С����"+bi2.min(bi1));
		
		BigInteger result[] = bi2.divideAndRemainder(bi1);//��������ĳ�������
		
		System.out.print("�̣�"+result[0]+";"+"������"+result[1]);
		
	}

}
