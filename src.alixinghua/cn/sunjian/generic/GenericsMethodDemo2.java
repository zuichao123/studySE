package cn.sunjian.generic;
/**
 * ���ͷ�������ϰ
 * 		
 * @author sunjian
 *
 */
class Info4<T extends Number>{//ָ�����ޣ�ֻ������������
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

public class GenericsMethodDemo2 {

	public static void main(String[] args) {
		Info4<Integer> i = fun(30);
		
		System.out.println(i);
		
	}
	
	//����һ�����أ�������Number��Info4���͵ķ��ͷ���fun
	public static <T extends Number> Info4<T> fun(T param){
		Info4<T> temp = new Info4<T>();//���ݴ������������ʵ����Info
		temp.setVar(param);//�����ݵ��������õ�Info�����var����֮��
		return temp;//����ʵ��������
	}

}
