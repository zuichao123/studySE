package cn.sunjian.numberformat;

import java.text.DecimalFormat;

/**
 *  NumberFormat类操作练习：
 *  
 *  	自定义格式化模板
 *  
 * @author sunjian
 *
 */

/*
 * 此方法专门用于完成数字的格式化显示
 */
class FormatDemo{
	
	public void format(String pattern,double value){
		DecimalFormat df = null;//声明一个DecimalFormat类的对象
		
		df = new DecimalFormat(pattern);//实例化对象，并传入模板
		
		String str = df.format(value);//格式化数字
		
		System.out.println("使用"+pattern+"模板，"+"格式化数字"+value+"，格式化后的值="+str+"\n");
	}
	
}

public class NumberFormatDemo {

	public static void main(String[] args) {
		
		FormatDemo fd = new FormatDemo();
		
		fd.format("###,###.###", 111222.34567);
		fd.format("000,000.000", 123222.345678);
		fd.format("###,###,###￥", 123123.234234);
		fd.format("000,000,000￥", 2343214.3234);
		fd.format("##.###%", 0.3453434);
		fd.format("00.###%", 0.034567);
		fd.format("###.###\u2030", 0.345678);
		
		/*
		 * 执行结果：
		 * 使用000,000.000模板，格式化数字123222.345678，格式化后的值=123,222.346
		 * 
		 * 使用###,###,###￥模板，格式化数字123123.234234，格式化后的值=123,123￥
		 * 
		 * 使用000,000,000￥模板，格式化数字2343214.3234，格式化后的值=002,343,214￥
		 * 
		 * 使用##.###%模板，格式化数字0.3453434，格式化后的值=34.534%
		 * 
		 * 使用00.###%模板，格式化数字0.034567，格式化后的值=03.457%
		 * 
		 * 使用###.###‰模板，格式化数字0.345678，格式化后的值=345.678‰
		 */
		
	}

}
