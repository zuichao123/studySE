package cn.sunjian.arrsys;

import java.util.Arrays;

/**
 * Arrays�������ϰ��
 * 
 * 		���÷�����ϰ
 * 
 * @author sunjian
 *
 */
public class ArraysDemo {

	public static void main(String[] args) {

		int[] temp = {2,6,464564,234,7,58,1,9};
		
		Arrays.sort(temp);//��������
		System.out.println("���������飺"+Arrays.toString(temp));
	
		//�����Ҫʹ�ö��ַ����ҵĻ�������������������
		int point = Arrays.binarySearch(temp, 7);//����λ��
		System.out.println("Ԫ��7��λ�ã�"+point);
		
		Arrays.fill(temp, 3456);//�������
		System.out.println("��������飺"+Arrays.toString(temp));
		
	}

}
