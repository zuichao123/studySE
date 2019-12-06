package cn.sunjian.numberformat;

import java.text.NumberFormat;

/**
 *  NumberFormat类操作练习：
 *  
 * @author sunjian
 *
 */
public class NumberFormatDemo2 {

	public static void main(String[] args) {
		NumberFormat nf = null;//声明一个NumberFormat对象
		
		nf = NumberFormat.getInstance();//得到默认的数字格式化显示
		
		System.out.println("格式化之后的数字："+nf.format(1000000));
		System.out.println("格式化之后的数字："+nf.format(1000.345));
	}

}
