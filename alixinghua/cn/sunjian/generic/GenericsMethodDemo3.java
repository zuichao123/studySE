package cn.sunjian.generic;
/**
 * ���ͷ�������ϰ
 * 		
 * 		ʹ�÷���ͳһ������������ͣ�
 * 
 * @author sunjian
 *
 */
class Info5<T>{
	private T var;//�������ԣ����������ⲿ����
	public void setVar(T var){
		this.var = var;
	}
	public T getVar(){
		return this.var;
	}
	
	//��дObject���е�toString����
	public String toString(){
		return this.var.toString();//��ӡ����
	}
}

public class GenericsMethodDemo3 {

	public static void main(String[] args) {
		Info5<String> i1 = new Info5<String>();
		Info5<String> i2 = new Info5<String>();
		
		i1.setVar("sunjian");//��������
		i2.setVar("Hello");//��������
		
		fun(i1, i2);
		
	}
	
	//ʹ�÷���ͳһ������������ͣ�������Ͳ�ͳһ���ᱨ��
	public static <T> void  fun(Info5<T>i1,Info5<T>i2){
		System.out.println(i1+"\t"+i2);
	}

}
