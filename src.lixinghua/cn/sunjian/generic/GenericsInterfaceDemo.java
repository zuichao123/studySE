package cn.sunjian.generic;
/**
 * ���ͽӿ���ϰ
 * 
 * ���ͽӿڵ�ʵ�ַ�ʽ��
 * 		�������ࣺ������Ķ�����Ҳ������������
 * 
 * @author sunjian
 *
 */

/*
 * ���巺�ͽӿ�
 */
interface Info3<T>{
	public T getVar();//������󷽷������󷽷��ķ���ֵ���Ƿ�������
}

/*
 * ʵ�ַ��ͽӿ�Info3
 */
class InfoImpl<T> implements Info3<T>{//���巺�ͽӿڵ�����
	private T var;//��������
	public InfoImpl(T var){//ͨ�����췽��������������
		this.setVar(var);
	}
	
	public void setVar(T var){//����set������������ֵ
		this.var = var;
	}
	public T getVar(){//��д����ӿڵķ���
		return this.var;
	}
}

public class GenericsInterfaceDemo {

	public static void main(String[] args) {
		Info3<String> i = null;//����ӿڶ���
		
		i = new InfoImpl<String>("sunjian");//����ʵ��������ӿڶ���
		
		System.out.println(i.getVar());
	}

}
