package cn.sunjian.news;
/**
 * �����ɱ����--��ϰ
 * �����Ŀɱ��������ʵ����һ�����飬���ǽ��յ��������Ԫ�أ�
 * �Զ�����ЩԪ�ط�װ�����飬���˵����ߵ���д��
 * 
 * ע�⣺�ɱ�������ͣ����붨���ڲ����б�Ľ�β��
 * @author sunjian
 *
 */
public class ParameterDemo {

	public static void main(String[] args) {
		
		int sum = newAdd(4,6,7,8,0,554,236,57);
		System.out.println(sum);
	}
	
	public static int newAdd(int... arr){
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum +=arr[i];
		}
		return sum;
	}

}
