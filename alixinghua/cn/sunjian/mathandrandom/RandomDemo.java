package cn.sunjian.mathandrandom;

import java.util.Random;

/**
 * Random�������ϰ��
 * 
 * 		����10��������������ֲ�����100
 * 
 * @author sunjian
 *
 */
public class RandomDemo {
	public static void main(String[] args) {
		Random r = new Random();//ʵ����random����
		
		for(int i=0;i<10;i++){
			System.out.print(r.nextInt(100)+" ");
		}
	}
}
