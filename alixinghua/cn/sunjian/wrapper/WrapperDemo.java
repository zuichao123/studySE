package cn.sunjian.wrapper;
/**
 * 包装类
 * 
 * 装箱、拆箱：整型
 * 
 * @author sunjian
 *
 */
public class WrapperDemo {

	public static void main(String[] args) {
		int x = 30;//基本数据类型
		Integer i = new Integer(x);//装箱：将基本数据类型变为包装类；
		@SuppressWarnings("unused")
		int temp = i.intValue();//拆箱：将一个包装类变为基本数据类型。
	}

}
