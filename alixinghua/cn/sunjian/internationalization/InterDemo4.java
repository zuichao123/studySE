package cn.sunjian.internationalization;

/**
 * ���ʻ�������ϰ��
 * 		
 * 		java�����ԣ�����ɱ����
 * 
 * 
 * @author jack
 *
 */
public class InterDemo4 {

	public static void main(String[] args) {

		System.out.print("��һ�����У�");
		Object[] arg1 = {"65r4e","sdfsd","erger","��ʱ����","����ɫ��"};
		fun(arg1);
		System.out.print("\n�ڶ������У�");
		Object[] arg2 = {"123","456","789"};
		fun(arg2);
		System.out.print("\n���������У�");
		Object[] arg3 = {"12asdfˮ���ˮ���"};
		fun(arg3);
	}

	private static void fun(Object... args) {//�̶��﷨���������������ݣ�ʹ�����ֱ�ʾ

		for(int x=0;x<args.length;x++){
			System.out.print(args[x]+"��");
		}
	}

}
