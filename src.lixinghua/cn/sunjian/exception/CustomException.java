package cn.sunjian.exception;

/**
 * �Զ����쳣��
 * 
 * @author sunjian
 *
 */

@SuppressWarnings("serial")
class MyException extends Exception {//�Զ����쳣�࣬�̳�Exception
	public  MyException(String msg){
		super(msg);//���ø����еĹ��췽����һ�������ģ�
	}
}

public class CustomException {

	public static void main(String[] args) {
		try{
			throw new MyException("�Զ����쳣����");//�׳��쳣
		}catch(Exception e){
			System.out.println(e);//�����񵽵��Զ����쳣��ӡ����
		}
	}

}
