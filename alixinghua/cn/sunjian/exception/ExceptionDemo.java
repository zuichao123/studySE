package cn.sunjian.exception;
/**
 * �쳣������ϰ
 * 
 * @author sunjian
 *
 */
public class ExceptionDemo {

	public static void main(String[] args) {
		System.out.println("���㿪ʼ��������������");
		int i = 10;
		int j = 0;
		
		try {
			int temp = i/j;//�˴������쳣
			System.out.println("���������="+temp);
			System.out.println("---------------");
		}catch(ArithmeticException e){//���������쳣
//			System.out.println(e);
			e.printStackTrace();
		}finally {
			System.out.println("�쳣��ͳһ���ڡ���");
		}
		System.out.println("�������������������");
	}

}
