package cn.sunjian.wrapper;
/**
 * 包装类
 * 
 * 装箱、拆箱：浮点型float
 * 
 * @author sunjian
 *
 */
public class WrapperDemo2 {

	public static void main(String[] args) {
		float x = 3.0f;//基本数据类型
		Float f = new Float(x);//装箱：将基本数据类型变为包装类；
		@SuppressWarnings("unused")
		float temp = f.floatValue();//拆箱：将一个包装类变为基本数据类型。
	}

}
