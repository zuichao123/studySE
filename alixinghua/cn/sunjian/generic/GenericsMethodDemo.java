package cn.sunjian.generic;
/**
 * 泛型方法的练习
 * 		
 * @author sunjian
 *
 */
class Demo{
	public <T> T fun(T t){//定义泛型方法，可以接收任意类型的数据
		return t;//直接把参数返回
	}
}

public class GenericsMethodDemo {

	public static void main(String[] args) {
		Demo d = new Demo();//实例化Demo队形
		
		String str = d.fun("sunjian");//传递字符串
		int i = d.fun(30);//传递数字，自动装箱
		
		System.out.println(str+i);//输出内容
	}

}
