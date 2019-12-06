package cn.sunjian.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

/**
 * java.IO操作：实例一练习
 * 
 * 	操作：
 * 		1.现在要求从键盘输入两个数字，之后完成两个数字的加法操作（整形、浮点型）
 * 		2.判断输入的是否是日期
 * 	思路：
 * 		因为从键盘接收过来的内容全部是采用字符串的形式存放的，所以
 * 		此时直接将字符串通过包装类Integer将字符串变为基本数据类型。
 * 			
 * 		
 * @author sunjian
 *
 */
public class TestInputData {

	public static void main(String[] args) throws IOException {

		newIntAddMethod();
		
		oldIntAddMethod();
		
		floatAddMethod();
		
		dateMethod();
			
	}

	private static void dateMethod() {
		
		InputData input = new InputData();
		
		Date date = input.getDate("请输入日期，格式为（yyyy-MM-dd）：", "您输入的日期格式不正确，请重新输入！");
		
		System.out.println(date);
	}

	private static void floatAddMethod() {
		
		float i = 0;
		float j = 0;
		
		InputData input = new InputData();
		
		i = input.getFloat("请输入第一个小数：", "输入的不是小数，请重新输入！");
		j = input.getFloat("请输入第二个小数：", "输入的不是小数，请重新输入！");
			
		System.out.println(i+"+"+j+"="+(i+j));
		
	}

	private static void newIntAddMethod() {
		int i = 0;
		int j = 0;
		
		InputData input = new InputData();
		
		i = input.getInt("请输入第一个数字：", "输入的不是数字，请重新输入！");
		j = input.getInt("请输入第二个数字：", "输入的不是数字，请重新输入！");
		
		System.out.println(i+"+"+j+"="+(i+j));
	}

	private static void oldIntAddMethod() throws IOException {
		int i = 0;//第一个数字
		int j = 0;//第二个数字
		
		BufferedReader buf = null;//接收键盘的输入数据
		
		buf = new BufferedReader(new InputStreamReader(System.in));//实例化
		
		String str = null;//接收数据
		
		System.out.println("请输入第一个数字：");
		str = buf.readLine();//接收第一个数据
		i = Integer.parseInt(str);//将接收的第一个字符串数据，转换成数字
		
		System.out.println("请输入第二个数字：");
		str = buf.readLine();//接收第二个数据
		j = Integer.parseInt(str);//将接收的第二个字符串数据，转换成数字
		
		System.out.println(i+"+"+j+"="+(i+j));
	}

}
