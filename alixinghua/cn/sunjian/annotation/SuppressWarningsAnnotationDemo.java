package cn.sunjian.annotation;
/**
 * Annotation：注释
 * 
 * 		@SuppressWarnings：压制安全警告；
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
	 * 以上只是压制了一个警告，也可以压制多个警告，可以通过数组是形式
	 */
}
