package cn.sunjian.digui;

public class DiGuiDemo {

	public static void main(String[] args) {

		
		/**
		 * �ݹ飺��������ֱ�������߼�ӵĵ�ż�Ǹ�������
		 * 
		 * ʲôʱ���ã�
		 * һ�����������ظ�ʹ�ã���ÿ��ʹ��ʱ����������Ľ������һ�ε����йأ���ʱ�����õݹ����������
		 * 
		 * ע�⣺�� 
		 * 1.�ݹ飺һ��Ҫ��ȷ��������������ջ���
		 * 2.ע��ݹ�Ĵ���
		 * 3.����������ȵ��ﵽ������Ž���
		 */
		
		
//		show();
//		toBin(6);
		
		
		int sum = getSum(9000);
		System.out.println(sum);
	}
	
	//�ݹ����
	public static int getSum(int num){
		
		if(num == 1)
			return 1;
			
		return num+getSum(num-1);
		
	}
	
	//�ݹ�ȡģ
	public static void toBin(int num){
		
		if(num>0){
			toBin(num/2);
			System.out.println(num%2);
//			num = num/2;
			
		}
	}

	
	/*public static void show(){
		
		method();
	}
	
	public static void method(){
		
		show();
	}*/
	
	
}
