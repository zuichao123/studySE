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
class Info2<T>{//���巺����Info
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

public class GenericsDemo2 {
	public static void main(String[] args) {
		Info2<String> i1 = new Info2<String>();//����String���͵Ķ���
		Info2<Object> i2 = new Info2<Object>();//����Object���͵Ķ���
		
		i1.setVar("hello");
		i2.setVar(new Object());
		
		fun(i1);
		fun(i2);
	}

	//���ý�������(��Ͳ��ܵ���String)��������String�༰�丸������ý��д���
	private static void fun(Info2<? super String> temp) {//����ʱ��ʹ�ã�
		System.out.print(temp+"��");
	}

}
