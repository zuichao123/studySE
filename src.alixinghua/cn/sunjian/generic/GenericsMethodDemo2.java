package cn.sunjian.generic;
/**
 * 泛型方法的练习
 * 		
 * @author sunjian
 *
 */
class Info4<T extends Number>{//指定上限，只能是数字类型
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

public class GenericsMethodDemo2 {

	public static void main(String[] args) {
		Info4<Integer> i = fun(30);
		
		System.out.println(i);
		
	}
	
	//定义一个返回（上限是Number）Info4类型的泛型方法fun
	public static <T extends Number> Info4<T> fun(T param){
		Info4<T> temp = new Info4<T>();//根据传入的数据类型实例化Info
		temp.setVar(param);//将传递的内容设置到Info对象的var属性之中
		return temp;//返回实例化对象
	}

}
