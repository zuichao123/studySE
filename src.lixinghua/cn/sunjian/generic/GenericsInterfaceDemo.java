package cn.sunjian.generic;
/**
 * 泛型接口练习
 * 
 * 泛型接口的实现方式：
 * 		定义子类：在子类的定义上也声明泛型类型
 * 
 * @author sunjian
 *
 */

/*
 * 定义泛型接口
 */
interface Info3<T>{
	public T getVar();//定义抽象方法，抽象方法的返回值就是泛型类型
}

/*
 * 实现泛型接口Info3
 */
class InfoImpl<T> implements Info3<T>{//定义泛型接口的子类
	private T var;//定义属性
	public InfoImpl(T var){//通过构造方法设置属性内容
		this.setVar(var);
	}
	
	public void setVar(T var){//定义set方法设置属性值
		this.var = var;
	}
	public T getVar(){//覆写父类接口的方法
		return this.var;
	}
}

public class GenericsInterfaceDemo {

	public static void main(String[] args) {
		Info3<String> i = null;//定义接口对象
		
		i = new InfoImpl<String>("sunjian");//子类实例化父类接口对象
		
		System.out.println(i.getVar());
	}

}
