package cn.sunjian.annotation;
/**
 * Annotation��ע��
 * 
 * 		@SuppressWarnings��ѹ�ư�ȫ���棻
 * 
 * @author jack
 *
 */
@Deprecated
class Demo3<T>{
	private T var ;
	public T getVar(){
		return this.var;
	}
	public void setVar(T var){
		this.var = var;
	}
}

public class SuppressWarningsAnnotationDemo {
	@SuppressWarnings(value = { "unchecked", "rawtypes" })
	public static void main(String[] args) {

		Demo3 d = new Demo3();
		d.setVar("sunjian");
		System.out.println(d.getVar());
	}

	/*
	 * ����ֻ��ѹ����һ�����棬Ҳ����ѹ�ƶ�����棬����ͨ����������ʽ
	 */
}
