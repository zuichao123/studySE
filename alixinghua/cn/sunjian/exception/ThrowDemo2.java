package cn.sunjian.exception;

/**
 * throw �� throws��Ӧ�ã�����
 * 
 * ��һ��Ŀ�����try catch finally throw throws����ʹ�õ���������ģ�
 * ���磺����Ҫ���һ������ķ�����
 * 	�����ڽ��в���֮ǰ�����ӡ�����㿪ʼ������Ϣ������֮��򿪡��쳣����������Ϣ
 * 	������쳣�Ļ�����Ӧ�ð��쳣���������ô��������������Ҫ�󣬾ͱ���ʹ�����ϵ�ȫ��������
 * 
 * @author sunjian
 *
 */

class Math{
	public int div(int i,int j)throws Exception{
		System.out.println("���㿪ʼ����");
		int temp = 0;
		try{
			temp = i/j;
		}catch(Exception e){
			throw e;
		}finally {			
			System.out.println("�����������");
		}
		return temp;
	}
}

public class ThrowDemo2 {

	public static void main(String[] args) {
		Math m = new Math();
		try{			
			System.out.println("��������"+m.div(10, 0));
		}catch(Exception e){
			System.out.println("�쳣������"+e);
		}
	}

}
