package cn.sunjian.interfaces;

/**
 * 为接口实例化对象
 * 
 * @author sunjian
 *
 */
interface AA{
	public void print();
}
class BB implements AA{
	public void print(){
		System.out.println("hello");
	}
}

public class InterfaceCaseDemo {

	public static void main(String[] args) {
		AA a = new BB();//通过子类为抽象类或接口实例化
		a.print();
	}

}
