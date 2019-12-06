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
class Info<T extends Number>{//定义泛型类Info,并设置上限，只能是Number的子类
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

public class GenericsDemo {
	public static void main(String[] args) {
		Info<Integer> i1 = new Info<Integer>();//定义Integer类型的对象
		Info<Float> i2 = new Info<Float>();//定义Float类型的对象
		
		i1.setVar(20);
		i2.setVar(30.123f);
		
		fun(i1);
		fun(i2);
	}

	//设置接收上限，必须是Number类的子类引用进行传递
	private static void fun(Info<? extends Number> temp) {//接收时，使用？
		System.out.print(temp+"、");
	}

}
