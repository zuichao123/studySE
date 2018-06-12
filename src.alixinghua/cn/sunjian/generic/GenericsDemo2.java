package cn.sunjian.generic;
/**
 * 泛型练习
 * 
 * 通配符？
 * 设置上限
 * 
 * @author sunjian
 *
 */
class Info2<T>{//定义泛型类Info
	private T var;
	
	public void setVar(T var){
		this.var = var;
	}
	public T getVar(){
		return this.var;
	}
	public String toString(){//直接打印
		return this.var.toString();
	}
}

public class GenericsDemo2 {
	public static void main(String[] args) {
		Info2<String> i1 = new Info2<String>();//定义String类型的对象
		Info2<Object> i2 = new Info2<Object>();//定义Object类型的对象
		
		i1.setVar("hello");
		i2.setVar(new Object());
		
		fun(i1);
		fun(i2);
	}

	//设置接收下限(最低不能低于String)，必须是String类及其父类的引用进行传递
	private static void fun(Info2<? super String> temp) {//接收时，使用？
		System.out.print(temp+"、");
	}

}
