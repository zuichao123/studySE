package cn.sunjian.object;
/**
 * Object ����ϰ
 * 
 * ʹ��Object��������
 * 
 * @author sunjian
 *
 */

public class ObjectDemo3 {

	public static void main(String[] args) {
		int temp[] = {1,2,5,7,9};
		Object obj = temp;//ʹ��Object��������
		print(obj);
	}

	private static void print(Object obj) {
		//�жϴ����object�Ƿ�����������
		if (obj instanceof int[]) {
			int x[] = (int[])obj;//��obj����ת��Ϊint[]������ֵ������x
			for (int i = 0; i < x.length; i++) {//��ӡ����
				System.out.println(x[i]);
			}
		}
	}

}
