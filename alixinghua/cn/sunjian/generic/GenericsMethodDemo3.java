package cn.sunjian.generic;
/**
 * 泛型方法的练习
 * 		
 * 		使用泛型统一传入参数的类型：
 * 
 * @author sunjian
 *
 */
class Info5<T>{
	private T var;//定义属性，此类型由外部决定
	public void setVar(T var){
		this.var = var;
	}
	public T getVar(){
		return this.var;
	}
	
	//覆写Object类中的toString方法
	public String toString(){
		return this.var.toString();//打印内容
	}
}

public class GenericsMethodDemo3 {

	public static void main(String[] args) {
		Info5<String> i1 = new Info5<String>();
		Info5<String> i2 = new Info5<String>();
		
		i1.setVar("sunjian");//设置内容
		i2.setVar("Hello");//设置内容
		
		fun(i1, i2);
		
	}
	
	//使用泛型统一传入参数的类型，如果类型不统一，会报错。
	public static <T> void  fun(Info5<T>i1,Info5<T>i2){
		System.out.println(i1+"\t"+i2);
	}

}
