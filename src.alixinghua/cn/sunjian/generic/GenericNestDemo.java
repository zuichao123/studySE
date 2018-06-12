package cn.sunjian.generic;
/**
 * ���͵�Ƕ��������ϰ
 * 
 * @author sunjian
 *
 */
class Info6<T,V>{
	private T var;
	private V value;
	
	
	public T getVar() {
		return var;
	}
	public void setVar(T var) {
		this.var = var;
	}
	public V getValue() {
		return value;
	}
	public void setValue(V value) {
		this.value = value;
	}
	
	public Info6(T var, V value) {
		this.var = var;
		this.value = value;
	}	
}

class Demo6<S>{
	private S info;
	
	public Demo6(S info){
		this.info = info;
	}
	public void setInfo(S info){
		this.info = info;
	}
	public S getInfo(){
		return this.info;
	}
}

public class GenericNestDemo {

	public static void main(String[] args) {
		Demo6<Info6<String,Integer>> d = null;//��Info��ΪDemo�ķ�������
		Info6<String,Integer> i = null;//Infoָ��������������
		
		i = new Info6<String,Integer>("sunjian",30);//ʵ�������Ͷ���
		d = new Demo6<Info6<String,Integer>>(i);//��Demo��������Info��Ķ���
		
		System.out.println("����һ��"+d.getInfo().getVar());//���
		System.out.println("���ݶ���"+d.getInfo().getValue());
		
	}

}
