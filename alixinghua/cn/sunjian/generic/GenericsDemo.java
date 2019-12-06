package cn.sunjian.generic;
/**
 * ������ϰ
 * 
 * ͨ�����
 * ��������
 * 
 * @author sunjian
 *
 */
class Info<T extends Number>{//���巺����Info,���������ޣ�ֻ����Number������
	private T var;
	
	public void setVar(T var){
		this.var = var;
	}
	public T getVar(){
		return this.var;
	}
	public String toString(){//ֱ�Ӵ�ӡ
		return this.var.toString();
	}
}

public class GenericsDemo {
	public static void main(String[] args) {
		Info<Integer> i1 = new Info<Integer>();//����Integer���͵Ķ���
		Info<Float> i2 = new Info<Float>();//����Float���͵Ķ���
		
		i1.setVar(20);
		i2.setVar(30.123f);
		
		fun(i1);
		fun(i2);
	}

	//���ý������ޣ�������Number����������ý��д���
	private static void fun(Info<? extends Number> temp) {//����ʱ��ʹ�ã�
		System.out.print(temp+"��");
	}

}
