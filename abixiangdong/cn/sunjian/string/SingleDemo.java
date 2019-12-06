package cn.sunjian.string;

/**
 * ����ģʽ�漰���Ķ��߳�����
 * @author sunjian
 *
 */

//����ʽ
class Single1{
	private static Single1 s = new Single1();
	
	private Single1(){
		System.out.println("���Ƕ���ʽ������ģʽ��");
	}
	
	public static Single1 getInstance(){
		return s;
	}
}



//����ʽ
class Single{
	private static Single s = null;
	
	private Single(){
		System.out.println("��������ʽ������ģʽ��");
	}
	
	public static Single getInstance(){
		//���һ���жϣ����Խ��Ч������
		if (s==null) {
			//�������Խ���̰߳�ȫ����
			synchronized (Single.class) { //Single.class����ֽ������
				if (s==null) {
					s = new Single();
				}
			}
		}
		return s;
	}
}





public class SingleDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Single1.getInstance();
		Single.getInstance();
	}

}
