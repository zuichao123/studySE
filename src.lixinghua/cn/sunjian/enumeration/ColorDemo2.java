package cn.sunjian.enumeration;
/**
 * 枚举：
 * 
 * 		通过普通类实现
 * 			
 * 		
 * @author sunjian
 *
 */
interface Color3{
	public static final String RED = "红色";
	public static final String BLUE = "蓝色";
	public static final String YELLOW = "黄色";
}

public class ColorDemo2 {

	public static void main(String[] args) {
		System.out.println(Color3.RED+Color3.YELLOW);	
	}
	
	/*
	 * 以接口的形式，达到枚举的功能。
	 */
}
